import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        Queue<struct> q;
        PriorityQueue<Integer> pq;
        int tc = Integer.parseInt(bf.readLine());
        for(int i=0; i<tc; i++) {
            q = new LinkedList<>();
            pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<n; j++) {
                int w = Integer.parseInt(st.nextToken());
                q.add(new struct(j, w));
                pq.add(w);
            }
            int idx = 1;
            while (true) {
                struct now = q.poll();
                int max_w = pq.poll();
                if (now.w == max_w) { // 큐의 가장 앞쪽을 뽑아서 봤는데, pq에 저장된 가장 큰 가중치라면 큐에서 빼버려야 함.
                    if (now.num == m) {
                        System.out.println(idx);
                        break;
                    }
                    idx++;
                } else if (now.w < max_w){ // 큐 맨 뒤로 이동.
                    q.add(now);
                    pq.add(max_w);
                }
            }
        }



    }
}
class struct {
    int num;
    int w;
    public struct(int n, int w) {
        this.num = n;
        this.w = w;
    }
}
