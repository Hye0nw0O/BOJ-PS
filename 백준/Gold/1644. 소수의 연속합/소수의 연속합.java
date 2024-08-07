import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n+1];
        for (int i=1; i<=n; i++) { arr[i] = i; }
        int prime_cnt = 0;
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (arr[i] == 0) continue;
            for (int j=i+i; j<n+1; j = j+i) {
                arr[j] = 0;
            }
        }
        for (int i=2; i<n+1; i++) {
            if (arr[i] != 0) {
                pq.add(arr[i]);
                prime_cnt++;
            }
        }
        int[] prime = new int[prime_cnt+1];
        int[] sum = new int[prime_cnt+1];
        for (int i=1; i<=prime_cnt; i++) {
            prime[i] = pq.poll();
        }
        for (int i=1; i<sum.length; i++) {
            sum[i] = prime[i] + sum[i-1];
        }
        int cnt = 0;
        int p1 = 0, p2 = 1;
        while (p1 < sum.length && p2 < sum.length) {
            int tmp = sum[p2] - sum[p1];
            if (tmp <= n) {
                if (tmp == n) {
                    cnt++;
                }
                p2++;
            } else {
                p1++;
            }
        }
        System.out.println(cnt);
    }
}