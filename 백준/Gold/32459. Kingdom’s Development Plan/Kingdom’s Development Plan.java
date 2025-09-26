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
        int[] deg = new int[n + 1];
        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            deg[v]++;
            arr[u].add(v);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=1; i<=n; i++) {
            if (deg[i] == 0) pq.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (! pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now).append(" ");
            for (int i : arr[now]) {
                deg[i]--;
                if (deg[i] == 0) {
                    pq.add(i);
                }
            }
        }
        boolean checker = true;
        for (int i=1; i<=n; i++) {
            if (deg[i] != 0) {
                checker = false;
                break;
            }
        }
        if (checker) System.out.print(sb);
        else System.out.println("IMPOSSIBLE");
    }
}