import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int INF = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int [n][n];
        int[] res = new int [n];
        for (int i=0; i<n; i++) {
            Arrays.fill(arr[i], INF);
        }
        for (int i=0; i<n; i++) {
            arr[i][i] = 0;
        }
        for (int i=0; i<n; i++) {
            String input = bf.readLine();
            for (int j=0; j<n; j++) {
                if (input.charAt(j) == 'Y') {
                    arr[i][j] = 1;
                }
            }
        }
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        for (int i=0; i<n; i++) {
            int cnt = 0;
            for (int j=0; j<n; j++) {
                if (arr[i][j] <= 2 && arr[i][j] > 0) {
                    cnt++;
                }
                res[i] = cnt;
            }
        }
        Arrays.sort(res);
        System.out.print(res[n-1]);
    }
}