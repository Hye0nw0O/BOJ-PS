import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n+1];
        for (int i=1; i<=n; i++) { arr[i] = i; }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            for (int j = 0; j < n; j++) {
                char tmp_c = input.charAt(j);
                if (tmp_c == '0') { continue; }
                int tmp = tmp_c - 96;
                if (tmp < 0) { tmp += 58; }
                sum += tmp;
                if (i != j) {
                    pq.add(new Edge(i+1, j+1, tmp));
                }
            }
        }
        int mst_w = 0;
        boolean mst = true;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (find(now.s) != find(now.e)) {
                mst_w += now.w;
                union(now.s, now.e);
            }
        }
        for (int i=1; i<=n; i++) {
            arr[i] = find(arr[i]);
        }
        int check = find(arr[1]);
        for (int i=2; i<=n; i++) {
            if (check != find(arr[i])) { mst = false; break;}
        }
        if (mst) System.out.print(sum - mst_w);
        else System.out.print(-1);
    }
    public static void union(int a, int b) {
        a = find(a); b = find(b);
        if (a != b) {
            arr[b] = a;
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
    public Edge (int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}