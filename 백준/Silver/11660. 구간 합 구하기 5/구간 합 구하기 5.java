import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int [n+1][n+1];
        int[][] sum = new int [n+1][n+1];
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=1; j<=n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sum[1][1] = arr[1][1];
        for (int i=2; i<=n; i++) {
            sum[0][i] = arr[0][i] + sum[0][i-1];
            sum[i][0] = arr[i][0] + sum[i-1][0];
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arr[i][j];
            }
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (x1 == x2 && y1 == y2) {
                System.out.println(arr[x1][y2]);
            } else {
                System.out.println(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]);
            }
        }


    }
}
