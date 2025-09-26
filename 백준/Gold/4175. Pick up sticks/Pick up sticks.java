import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            int[] deg = new int[n + 1];
            ArrayList<Integer>[] arr = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u].add(v);
                deg[v]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (deg[i] == 0) {
                    q.add(i);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                int now = q.poll();
                sb.append(now).append("\n");
                for (int i : arr[now]) {
                    deg[i]--;
                    if (deg[i] == 0) {
                        q.add(i);
                    }
                }
            }
            boolean check = true;
            for (int i = 1; i <= n; i++) {
                if (deg[i] != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print(sb);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}