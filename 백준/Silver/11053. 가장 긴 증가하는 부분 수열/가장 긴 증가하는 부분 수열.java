import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> h = new PriorityQueue<>();
        int n = Integer.parseInt(bf.readLine());
        int arr[] = new int [n];
        int dp[] = new int [n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;
        for (int i=1; i<n; i++) {
            int max = 0;
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, dp[j]);
                }
                dp[i] = max+1;
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}
