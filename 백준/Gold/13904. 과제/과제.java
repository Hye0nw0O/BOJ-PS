import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Work> pq = new PriorityQueue<>(); // w 큰 순서대로 poll, w 같으면 d가 큰 순서대로 poll
        int n = Integer.parseInt(bf.readLine());
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Work(d, w));
        }
        int max = 0;
        int[] day = new int[1001];
        while (! pq.isEmpty()) {
            Work tmp = pq.poll();
            if (day[tmp.d] == 0) {
                day[tmp.d] = 1;
                max += tmp.w;
            } else {
                for (int i=tmp.d-1; i>0; i--) {
                    if (day[i] == 0) {
                        day[i] = 1;
                        max += tmp.w;
                        break;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
class Work implements Comparable<Work> {
    int d, w;
    public Work (int d, int w) {
        this.d = d; this.w = w;
    }
    public int compareTo (Work o) {
        if (this.w != o.w) {
            return o.w - this.w;
        } else {
            return o.d - this.d;
        }
    }
}