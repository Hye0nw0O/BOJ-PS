import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] deg;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        int tc = Integer.parseInt(bf.readLine());
        for (int z=0; z<tc; z++) {
            Queue<Integer> q = new LinkedList<>();
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new ArrayList[n+1];
            for (int i=1; i<=n; i++) { arr[i] = new ArrayList<>(); }
            deg = new int[n+1];
            cost = new int[n+1];
            st = new StringTokenizer(bf.readLine());
            for (int i=1; i<=n; i++) { cost[i] = Integer.parseInt(st.nextToken()); }
            for (int i=0; i<m; i++) {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u].add(v);
                deg[v]++; // 진입 차수 증가
            }
            int w = Integer.parseInt(bf.readLine());
            for (int i=1; i<=n; i++) {
                if (deg[i] == 0) q.add(i);
            }
            int[] tmp = new int[n+1]; // i번째 건물의 선행 건물 건설에 필요한 시간.
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int i : arr[now]) { // i는 큐에서 poll한 now와 연결된 정점.
                    deg[i]--;
                    tmp[i] = Math.max(tmp[i], tmp[now] + cost[now]); // 따라서 연결된 정점 i 건설의 소요 시간 vs 현재 now 노드 건물 소요 시간
                    if (deg[i] == 0) {
                        q.add(i);
                    }
                }
            }
            System.out.println(tmp[w] + cost[w]);
        }

    }
}