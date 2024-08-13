import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node>[] arr;
    static int[] dis;
    static boolean[] visit;
    static int[] pre;
    static int INF = 90000009;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int n = Integer.parseInt(bf.readLine());
        arr = new ArrayList[n+1];
        dis = new int[n+1]; Arrays.fill(dis, INF);
        visit = new boolean[n+1];
        pre = new int[n+1];
        for (int i=1; i<=n; i++) { arr[i] = new ArrayList<>(); }
        int m = Integer.parseInt(bf.readLine());
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u].add(new Node(v, w));
        }
        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        pq.add(new Node(start, 0));
        dis[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll(); // 현재 노드는 now
            if (visit[now.n]) { continue; }
            visit[now.n] = true;
            for (Node i : arr[now.n]) { // now와 연결된 정점 i에 대해서 실행
                if (dis[i.n] > i.w + dis[now.n]) { // now 정점을 경유해서 i 정점으로 가는게 i로 직행하는 것보다 짧은 경우, 해당 경로 업데이트
                    dis[i.n] = i.w + dis[now.n];
                    pq.add(new Node(i.n, dis[i.n]));
                    pre[i.n] = now.n; // pre 배열: i번 노드 최단 거리로 방문 위한 이전 노드 저장.
                }
            }
        }
        System.out.println(dis[end]);
        ArrayList<Integer> list = new ArrayList<>();
        // end 정점에서 시작하여 경로 역추적
        // end 정점 최단거리 위한 이전 정점 방문. 이 과정을 start 정점 도달할 때 까지 반복하여 경로 역추적.
        int idx = end;
        while (idx != 0) {
            list.add(idx);
            idx = pre[idx];
        }
        System.out.println(list.size());
        Collections.reverse(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
class Node implements Comparable<Node> {
    int n, w;
    public Node (int n, int w) {
        this.n = n; this.w = w;
    }
    public int compareTo(Node N) {
        return this.w - N.w;
    }
}