import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(bf.readLine());
        PriorityQueue<Long> pq;
        for (int z = 0; z<tc; z++) {
            pq = new PriorityQueue<>();
            int n = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for (int i=0; i<n; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long res = 1;
            while (pq.size() > 1) {
                long p1 = pq.poll(); long p2 = pq.poll();
                long mul = p1 * p2;
                res *= mul % MOD;
                res %= MOD;
                pq.add(mul);
            }
            System.out.println(res);
        }
    }
}