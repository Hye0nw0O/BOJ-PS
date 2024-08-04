import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] UF;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        UF = new int[n+1];
        for (int i=1; i<=n; i++) { UF[i] = i; }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(u, v, w));
        }
        long res = 0;
        while (! pq.isEmpty()) { // union find 알고리즘 이용. => 현재 엣지의 s, e 노드 연결 시 사이클 형성하는지 판정하며 간선 연결
            Edge now = pq.poll();
            if (find(now.s) != find(now.e)) {
                res += now.w;
                union(now.s, now.e);
            }
        }
        System.out.print(res);
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            UF[b] = a;
        }
    }
    public static int find(int n) {
        if (UF[n] == n) {
            return n;
        } else {
            return UF[n] = find(UF[n]);
        }
    }
}
class Edge implements Comparable<Edge> {
    int s, e, w;
    public Edge (int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}