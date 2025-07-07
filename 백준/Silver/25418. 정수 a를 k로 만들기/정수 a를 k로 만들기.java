import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static Queue<Temp> q;
    public static boolean[] visit;
    public static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        q = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new boolean[k+1];
        q.add(new Temp(n, 0));
        visit[n] = true;
        while (! q.isEmpty()) {
            Temp t = q.poll();
            int idx = t.n;
            int cnt = t.count;
            if (idx == k) { System.out.println(cnt); break; }

            if (idx * 2 <= k && !visit[idx * 2]) {
                q.add(new Temp(idx * 2, cnt + 1));
                visit[idx * 2] = true;
            }
            if (idx + 1 <= k && !visit[idx + 1]) {
                q.add(new Temp(idx + 1, cnt + 1));
                visit[idx + 1] = true;
            }
        }
    }

    public static class Temp {
        int n;
        int count;
        public Temp(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
}
