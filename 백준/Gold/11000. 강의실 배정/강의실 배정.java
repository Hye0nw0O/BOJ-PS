import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        List<time> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new time(start, end));
        }
        Collections.sort(list);
        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        int res = 1;
        for (int i=0;i<n; i++) {
            while (!pq.isEmpty() && pq.peek() <= list.get(i).start) {
                pq.poll();
            }
            pq.add(list.get(i).end);
            res = Math.max(res, pq.size());
        }
        System.out.println(res);
    }
}

class time implements Comparable<time> {
    int start, end;
    public time(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public int compareTo(time t) { 
        if (this.start == t.start) {
            return this.end - t.end;
        }
        else {
            return this.start - t.start;
        }
    }
}