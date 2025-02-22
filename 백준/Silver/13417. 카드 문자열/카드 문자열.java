import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(bf.readLine());
        Deque<String> deq;
        String res;
        for (int i=0; i<k; i++) {
            int n = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            deq = new LinkedList<>();
            res = "";
            for (int z = 0; z<n; z++) {
                String str = st.nextToken();
                deq.add(str);
            }
            res = res.concat(deq.poll());
            for (int z=0; z<n-1; z++) {
                String tmp = deq.poll();
                if (res.charAt(0) >= tmp.charAt(0)) {
                    res = tmp + res;
                } else {
                    res = res + tmp;
                }
            }
            System.out.println(res);
        }

    }
}