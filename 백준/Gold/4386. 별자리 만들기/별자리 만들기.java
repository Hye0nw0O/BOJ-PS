import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] par;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        ArrayList<Point> p = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        par = new int[n+1];
        for (int i=1; i<=n; i++) { par[i] = i; }
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(bf.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            p.add(new Point(x, y));
        }
        for (int i=1; i<n; i++) { // 1~n 사이의 정점 모두 연결
            for (int j=i+1; j<=n; j++) {
                pq.add(new Edge(i, j, dis(p.get(i-1), p.get(j-1)))); // i -> j, Edge 가중치는 두 점 사이의 거리
            }
        }
        double res = 0.0;
        int Edge_cnt = 0;
        while (Edge_cnt != n-1) {
            Edge now = pq.poll();
            if (find(now.start) != find(now.to)) {
                union(now.start, now.to);
                res += now.w;
                Edge_cnt++; // 두 점 연결한 경우에만 Edge 개수 증가
            }
        }
        System.out.printf("%.2f", res);
    }
    public static void union (int a, int b) {
        a = find(a); b = find(b);
        if (a != b) {
            par[b] = a;
        }
    }
    public static int find (int a) {
        if (par[a] == a) return a;
        else
            return par[a] = find(par[a]);
    }
    public static double dis (Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
class Edge implements Comparable <Edge> {
    int start; int to; double w;
    public Edge(int start, int to, double w) {
        this.start = start; this.to = to; this.w = w;
    }
    public int compareTo(Edge e) {
        return Double.compare(this.w, e.w);
    }
}
class Point {
    double x, y;
    public Point(double x, double y) {
        this.x = x; this.y = y;
    }
}