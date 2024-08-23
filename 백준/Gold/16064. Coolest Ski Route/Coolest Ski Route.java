import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] arr = new ArrayList[n+1];
        int[] deg = new int[n+1];
        int[] dp = new int [n+1];
        for (int i=1; i<=n; i++) { arr[i] = new ArrayList<>(); }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            deg[v]++;
            arr[u].add(new Edge(v, w));
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Edge i : arr[now]) {
                deg[i.to]--;
                dp[i.to] = Math.max(dp[i.to], dp[now] + i.w);
                if (deg[i.to] == 0) {
                    q.add(i.to);
                }
            }
        }
        int res = -1;
        for (int i=1; i<=n; i++) {
            res = Math.max(dp[i], res);
        }
        System.out.println(res);
    }
}
class Edge {
    int to, w;
    public Edge (int to, int w) {
        this.to = to; this.w = w;
    }
}