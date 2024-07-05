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
        int[][] arr = new int [n][m];
        int[][] dp = new int [n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for (int i=1; i<n; i++) {
            dp[i][0] = arr[i][0] + dp[i-1][0];
        }
        for (int i=1; i<m; i++) {
            dp[0][i] = arr[0][i] + dp[0][i-1];
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                dp[i][j] = arr[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
