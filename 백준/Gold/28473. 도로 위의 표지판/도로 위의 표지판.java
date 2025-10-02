import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] info;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        info = new int[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i=1; i<=n; i++) { info[i] = i; }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(u, v, num, w));
        }
        StringBuilder res_num = new StringBuilder();
        int edge_cnt = 0;
        long cost = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (find(now.u) != find(now.v)) {
                union(now.u, now.v);
                res_num.append(now.n);
                cost += now.w;
                edge_cnt++;
            }
            if (edge_cnt == n-1) break;
        }
        if (edge_cnt == n-1) System.out.print(res_num + " " + cost);
        else System.out.println(-1);
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) info[b] = a;
    }
    public static int find(int a) {
        if (info[a] == a) { return a; }
        else { return info[a] = find(info[a]); }
    }
}
class Edge implements Comparable<Edge> {
    int u, v, n, w;
    public Edge(int u, int v, int n, int w) {
        this.u = u;
        this.v = v;
        this.n = n;
        this.w = w;
    }
    public int compareTo(Edge e) { // 번호 작은 것 우선. => 번호 같으면 cost 작은 것 우선
        if (this.n != e.n) return this.n - e.n;
        else return this.w - e.w;
    }
}