import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int [n];
        int[] dp = new int [n];
        for (int i=0; i<n; i++) { arr[i] = Integer.parseInt(bf.readLine()); }
        dp[0] = 1;
        for (int i=1; i<n; i++) {
            int tmp = 0;
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    tmp = Math.max(dp[j], tmp);
                }
            }
            dp[i] = tmp + 1;
        }
        int res = -1;
        for (int i=0; i<n; i++) { res = Math.max(res, dp[i]); }
        System.out.println(n - res);
    }
}