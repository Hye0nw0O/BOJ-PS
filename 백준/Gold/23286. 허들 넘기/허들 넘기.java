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
        int tc = Integer.parseInt(st.nextToken());
        int[][] arr = new int [n+1][n+1];
        for (int i=1; i<=n; i++) {
            Arrays.fill(arr[i], INF);
        }
        for (int i=1; i<=n; i++) { arr[i][i] = 0; }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u][v] = w;
        }
        // case 1: i -> j로 직행
        // case 2: i -> k -> j 경로 => k 정점을 경유하게 됨. 이 경유, 최대 허들 높이는 i -> k, k -> j중 더 큰 값.
        // case 1, case 2의 두 값 중 작은 값이 가장 큰 값중 최솟값.
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (arr[i][k] != INF && arr[k][j] != INF) {
                        int tmp1 = arr[i][j];
                        int tmp2 = Math.max(arr[i][k], arr[k][j]);
                        arr[i][j] = Math.min(tmp1, tmp2); //
                    }
                }
            }
        }
        for (int i=0; i<tc; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (arr[s][e] == INF) System.out.println(-1);
            else System.out.println(arr[s][e]);
        }
    }
}