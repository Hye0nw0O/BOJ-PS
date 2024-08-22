import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> neg = new PriorityQueue<>();
        int cnt_0 = 0;
        int cnt_1 = 0;
        int n = Integer.parseInt(bf.readLine());
        for (int i=0; i<n; i++) {
            int input = Integer.parseInt(bf.readLine());
            if (input > 1) pos.add(input);
            else if (input < 0) neg.add(input);
            else if (input == 0) cnt_0++;
            else cnt_1++;
        }
        int res = 0;
        while (pos.size() > 1) {
            int tmp = pos.poll() * pos.poll();
            res += tmp;
        }
        while (neg.size() > 1) { // 이 이후에는 neg pq에 남은 원소는 1 or 0
            int tmp = neg.poll() * neg.poll();
            res += tmp;
        }
        if (pos.size() == 1) res += pos.poll(); // 남은 양수가 있다면 더함.
        res += cnt_1; // 1의 개수 더함
        if (neg.size() == 1 && cnt_0 == 0) { // 음수 남아 있는데 0이 없음
            res += neg.poll();
        }
        System.out.println(res);
    }
}