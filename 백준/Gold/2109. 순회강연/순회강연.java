import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        PriorityQueue<Task> pq = new PriorityQueue<>();
        int n = Integer.parseInt(bf.readLine());
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            pq.add(new Task(pay, day));
        }
        int[] check = new int[10001];
        int res = 0;
        while(!pq.isEmpty()) {
            Task now = pq.poll();
            if (check[now.day] == 0) { // 해당 일자에 강의 없으면
                check[now.day] = 1; // 강의 실행
                res += now.pay;
            } else { // 해당 일자에 강의가 있는 경우
                for (int i=now.day; i>0; i--) { // 날짜를 1일씩 줄이며 비어있는 날짜 탐색해 그 날짜에 강의 진행.
                    if (check[i] == 0) {
                        check[i] = 1;
                        res += now.pay;
                        break;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
class Task implements Comparable <Task>{
    int pay, day;
    public Task (int pay, int day) {
        this.pay = pay; this.day = day;
    }
    public int compareTo (Task o) { // pq에서 pay가 큰 순으로 poll. pay 동일한 경우 day가 큰 순으로 poll
        if (this.pay != o.pay) {
            return o.pay - this.pay;
        } else {
            return o.day - this.day;
        }
    }
}