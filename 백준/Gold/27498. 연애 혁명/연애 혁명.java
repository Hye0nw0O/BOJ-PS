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
        int sum = 0;
        int pre_cost = 0;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (r == 0) {
                pq.add(new Edge(u, v, w));
            } else {
                union(u, v);
                pre_cost += w;
            }
            sum += w;
        }
        int cost = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (find(now.u) != find(now.v)) {
                union(now.u, now.v);
                cost += now.w;
            }
        }
        System.out.println(sum - (cost + pre_cost));
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
    int u, v, w;
    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
    public int compareTo(Edge e) {
        return e.w - this.w;
    }
}