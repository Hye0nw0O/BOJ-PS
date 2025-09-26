import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            int[] deg = new int [n + 1];
            ArrayList<Integer>[] arr = new ArrayList[n + 1];
            for (int i=1; i<=n; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i=0; i<m; i++) {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                deg[v]++;
                arr[u].add(v);
            }
            Queue<Integer> q = new LinkedList<>();

            boolean check0 = true;
            boolean check1 = true;
            boolean check2 = true;
            int zerocnt = 0;

            for (int i=1; i<=n; i++) {
                if (deg[i] == 0) {
                    q.add(i);
                    zerocnt++;
                }
            }

            while (! q.isEmpty()) {
                int now = q.poll();
                int cnt = 0;
                for (int i : arr[now]) {
                    deg[i]--;
                    if (deg[i] == 0) { // 진입 차수 0인 노드 삽입
                        q.add(i);
                        cnt++;
                    }
                }
                if (cnt > 1) {
                    check1 = false;
                }
            }

            for (int i=1; i<=n; i++) {
                if (deg[i] != 0) {
                    check0 = false;
                }
            }

            if (! check0) { // 진입 차수 0이 아닌 노드가 있으면 0.
                System.out.println(0);
            } else {
                if (zerocnt > 1) { // 시작 시 진입 차수 0인 노드 2개 이상 => 2
                    System.out.println(2);
                } else if (! check1) {
                    System.out.println(2);
                } else {
                    System.out.println(1);
                }
            }
        }
    }
}