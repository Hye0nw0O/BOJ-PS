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
        arr = new int[n+1];
        for (int i=1; i<=n; i++) { arr[i] = i; }
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Point> points = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }
        int cnt_E = 0;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            if (find(p1) != find(p2)) {
                union(p1, p2);
                cnt_E++;
            } // 이미 연결되었으므로 union
        }
        for (int i=1; i<n; i++) {
            for (int j=i+1; j<=n; j++) {
                double tmp_w = get_w(points.get(i-1), points.get(j-1));
                pq.add(new Edge(i, j, tmp_w));
            }
        }

        double result = 0;
        while (cnt_E < n-1) {
            Edge now = pq.poll();
            if (find(now.u) != find(now.v)) {
                union(now.u, now.v);
                result += now.w;
                cnt_E++;
            }
        }
        System.out.printf("%.2f", result);
    }
    public static double get_w (Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
    public static void union(int x, int y) {
        x = find(x); y = find(y);
        if (x != y) {
            arr[y] = x;
        }
    }
    public static int find(int x) {
        if (arr[x] == x)
            return x;
        else
            return arr[x] = find(arr[x]);
    }
}
class Edge implements Comparable<Edge> {
    int u, v;
    double w;
    public Edge(int u, int v, double w) {
        this.u = u; this.v = v; this.w = w;
    }
    public int compareTo(Edge e) {
        return Double.compare(this.w, e.w);
    }
}
class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x; this.y = y;
    }
}