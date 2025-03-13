import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static double INF = 9009.9;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        while (true) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            int m = Integer.parseInt(st.nextToken());
            double[][] arr = new double[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    Arrays.fill(arr[i], 0);
                }
            }
            for (int i = 1; i <= n; i++) { // 자기 자신 정점은 안전.
                arr[i][i] = 1.0;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                arr[u][v] = w / 100.0;     // 확률로 변경
                arr[v][u] = w / 100.0;     // 확률로 변경
            }
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        arr[i][j] = Math.max(arr[i][j], arr[i][k] * arr[k][j]);
                    }
                }
            }
            System.out.printf("%.6f", arr[1][n] * 100);
            System.out.print(" percent\n");
        }
    }
}