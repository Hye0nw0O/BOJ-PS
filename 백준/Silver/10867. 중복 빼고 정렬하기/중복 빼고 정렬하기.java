import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (! pq.contains(x)) {
                pq.add(x);
            }
        }
        while (! pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

    }
}