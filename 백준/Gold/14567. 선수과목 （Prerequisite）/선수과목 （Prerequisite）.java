import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] arr;
    public static int[] deg;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        deg = new int[n + 1];
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            deg[v]++;
        }
        int seq = 1;
        Queue<Integer> q = new LinkedList<>(); // 큐에 진입 차수가 0인 노드 삽입.
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) {
                q.add(i);
                res[i] = seq;
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : arr[now]) { // 진입 차수 0인 노드와 연결된 노드의 진입 차수 감소
                deg[i]--;
                if (deg[i] == 0) {
                    q.add(i);
                    res[i] = res[now] + 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

