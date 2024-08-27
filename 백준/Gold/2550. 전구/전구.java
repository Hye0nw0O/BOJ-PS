import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        int[] arr1 = new int[n+1];
        int[] arr2 = new int[n+1];
        int[] seq = new int[n+1];
        int[] dp = new int[n+1];
        st = new StringTokenizer(bf.readLine());
        for (int i=1; i<=n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i=1; i<=n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=1; i<=n; i++) { // seq 배열에서 LIS 찾기.
            for (int j=1; j<=n; j++) {
                if (arr1[i] == arr2[j]) {
                    seq[i] = j;
                    break;
                }
            }
        }
        Arrays.fill(dp, 1);
        for (int i=2; i<=n; i++) {
            int tmp = 0; // 임시 길이 0
            for (int j=1; j<i; j++) {
                if (seq[i] > seq[j]) {
                    tmp = Math.max(tmp, dp[j]);
                }
            }
            dp[i] = tmp + 1;
        }
        int len = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i=1; i<=n; i++) { len = Math.max(len, dp[i]); }
        int cnt = len;
        for (int i=n; i>0; i--) {
            if (cnt == dp[i]) {
                cnt--;
                stack.push(arr1[i]);
            }
            if (cnt == 0) break;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (!stack.isEmpty()) {
            pq.add(stack.pop());
        }
        System.out.println(len);
        while(!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}