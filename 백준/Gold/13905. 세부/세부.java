import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        arr = new int[n+1];
        for (int i=1; i<=n; i++) { arr[i] = i; }
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(u, v, w));
        }
        int res = 1000001;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                res = Math.min(res, now.w);
            }
            if (find(start) == find(end)) {break;}
        }
        if (find(start) == find(end)) System.out.println(res);
        else System.out.println(0);
    }
    public static void union(int x, int y) {
        x = find(x); y = find(y);
        if (x != y) {
            arr[y] = x;
        }
    }
    public static int find(int n) {
        if (arr[n] == n) {
            return n;
        } else {
            return arr[n] = find(arr[n]);
        }
    }
}
class Edge implements Comparable<Edge> {
    int s, e, w;
    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
    public int compareTo(Edge o) { // pq에서 가중치 큰 간선부터 빠지도록 설정.
        return o.w - this.w;
    }
}