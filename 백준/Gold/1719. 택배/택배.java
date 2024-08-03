import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 99999999;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int [n+1][n+1];
        int[][] res = new int [n+1][n+1];
        for (int i=1; i<=n; i++) { Arrays.fill(arr[i], INF); }
        for (int i=1; i<=n; i++) { arr[i][i] = 0; }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u][v] = w; arr[v][u] = w;
            res[u][v] = v; res[v][u] = u; // 초기값: 인접 노드는 인접한 노드를 거쳐가도록 설정.
        }
        for (int k=1; k<=n; k++) { // k: 거쳐가는 중간 노드
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        res[i][j] = res[i][k]; // i -> k -> j로 향할 때, i -> k를 먼저 실행. 즉, i에서 k 노드로 먼저 향함.
                    }
                }
            }
        }
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i == j)
                    System.out.print("- ");
                else
                    System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}