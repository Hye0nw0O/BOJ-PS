import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder()); // 양수는 큰 값 부터
        PriorityQueue<Integer> neg = new PriorityQueue<>(); // 음수는 작은 값 부터
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input > 0) pos.add(input);
            else neg.add(input);
        }
        while (!pos.isEmpty()) {
            int tmp_max;
            if (pos.size() >= k) {
                tmp_max = pos.poll();
                pq.add(tmp_max);
                for (int i = 0; i < k - 1; i++) { pos.poll(); }
            } else {
                tmp_max = pos.poll();
                pq.add(tmp_max);
                break;
            }
        }
        while (!neg.isEmpty()) {
            int tmp_min;
            if (neg.size() >= k) {
                tmp_min = neg.poll() * -1;
                pq.add(tmp_min);
                for (int i=0; i<k-1; i++) { neg.poll(); }
            } else {
                tmp_min = neg.poll() * -1;
                pq.add(tmp_min);
                break;
            }
        }
        int res = 0;
        int i = 0;
        while (!pq.isEmpty()) {
            if (i == 0) res += pq.poll();
            else res += pq.poll() * 2;
            i++;
        }
        System.out.println(res);
    }
}