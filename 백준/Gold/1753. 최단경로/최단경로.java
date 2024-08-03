import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node>[] arr;
    static int[] dis;
    static boolean[] visit;
    static int INF = 99999999;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(bf.readLine());
        arr = new ArrayList[n+1];
        dis = new int[n+1];
        visit = new boolean[n+1];
        Arrays.fill(dis, INF);
        for (int i=1; i<=n; i++) { arr[i] = new ArrayList<>(); }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u].add(new Node(v, w));
        }
        pq.add(new Node(start, 0));
        dis[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int now_n = now.n; // 현재 노드 번호
            if (visit[now_n]) {
                continue;
            }
            visit[now_n] = true;
            for (Node tmp : arr[now_n]) { // 현재 노드와 연결된 노드에 대하여 루프.
                int tmp_n = tmp.n; // 연결된 노드 번호
                int tmp_w = tmp.w; // 연결된 노드의 가중치
                if (dis[tmp_n] > tmp_w + dis[now_n]) { // 현재 노드까지 도달하는데 필요한 가중치 + 연결된 노드의 가중치 값이 지금 dis 값보다 작다면, 업데이트.
                    dis[tmp_n] = tmp_w + dis[now_n];
                    pq.add(new Node(tmp_n, dis[tmp_n]));
                }
            }
        }
        for (int i=1; i<=n; i++) {
            if (visit[i]) System.out.println(dis[i]);
            else System.out.println("INF");
        }
    }
}
class Node implements Comparable<Node> {
    int n, w;
    public Node(int n, int w) {
        this.n = n;
        this.w = w;
    }
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}