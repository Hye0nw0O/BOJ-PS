import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean visited[];
    public static int graph[][];
    public static int n, m, v; // 정점, 간선, 시작 정점
    public static int cnt = 0;
    public static HashSet<Integer> set = new HashSet<>();
    public static void bfs (int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(! q.isEmpty()) {
            int tmp = q.poll();
            set.add(tmp);
            for (int k=1; k<=n; k++) {
                if (graph[tmp][k] == 1 && !visited[k]) {
                    q.offer(k);
                    visited[k] = true;
                }
            }
        }
        cnt++;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int [n+1][n+1];
        visited = new boolean[n+1];
        m = Integer.parseInt(st.nextToken());
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for (int i=1; i<=n; i++) {
            if (set.contains(i)) {
                continue;
            } else {
                bfs(i);
            }
        }
        System.out.println(cnt);

    }
}
