import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 문제 해결 아이디어: 임의 노드에서 가장 먼 노드를 bfs를 이용해 구함 => 가장 멀리 있는 노드는 트리의 지름에 반드시 포함됨.
// 이후 구한 가장 멀리 있는 노드에서 bfs를 실행해 트리의 지름을 구함.
public class Main {
    static ArrayList<node>[] arr;
    static int[] dis; // 얼마나 멀리 떨어져 있는지 거리 저장
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        arr = new ArrayList[n+1];
        dis = new int [n+1];
        visit = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(bf.readLine());
            int node_num = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) { break; }
                int w = Integer.parseInt(st.nextToken());
                arr[node_num].add(new node(e, w));
            }
        }
        // 노드 추가 완료
        bfs(1); // 임의 노드인 1에서 bfs 실행
        int node_idx = 1;
        for (int i=2; i<=n; i++) {
            if (dis[node_idx] < dis[i]) {
                node_idx = i;
            }
        }
        dis = new int[n+1];
        visit = new boolean[n+1];
        bfs(node_idx); // 노드 1과 가장 멀리 있는 노드 번호가 node_idx에 저장됨. 따라서 node_idx에서 bfs 실행
        Arrays.sort(dis);
        System.out.println(dis[n]);
    }
    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (node i : arr[now]) {
                int te = i.e;
                int tw = i.w;
                if (!visit[te]) { // now 노드와 연결된 te 노드를 방문하지 않은 경우, 그 노드를 큐에 추가
                    visit[te] = true; // te 노드 방문 처리
                    q.add(te);
                    dis[te] = dis[now] + tw; // dis 배열이 연결된 노드 now까지의 거리와 가중치를 합한 값으로 업데이트됨
                }
            }
        }
    }
    
}
class node {
    int e, w; // e는 노드 넘버, w는 가중치
    public node (int e, int w) {
        this.e = e;
        this.w = w;
    }
}