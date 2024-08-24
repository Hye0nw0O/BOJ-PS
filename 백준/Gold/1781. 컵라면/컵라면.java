import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        List<sol> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            int due = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new sol(due, w));
        }
        Collections.sort(list); // 마감 기한 짧은 순으로 정렬. 기한 같으면 w 큰 순서로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // pq 크기 = 마감 기한
        for (int i=0; i<list.size(); i++) {
            int now_d = list.get(i).due;
            int now_w = list.get(i).w;
            pq.add(now_w); // 일단 pq에 삽입.
            if (now_d < pq.size()) { // pq 크기(마감 기한) < now_d라면, 방금 넣은 과제는 수행 불가.
                pq.poll();
            }
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}
class sol implements Comparable<sol> {
    int due, w;
    public sol (int due, int w) {
        this.due = due;
        this.w = w;
    }
    public int compareTo (sol s) {
        if (this.due == s.due) { // due 같으면 w가 큰 것부터
            return s.w - this.w;
        } else { // due가 다르면 due가 작은 것부터
            return this.due - s.due;
        }
    }
}