import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] time;
    static int[] res; // total time
    static int[] deg;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        time = new int[n+1];
        res = new int[n+1];
        deg = new int[n+1];
        for (int i=1; i<=n; i++) { arr[i] = new ArrayList<>(); }
        for (int i=1; i<=n; i++) {
            time[i] = Integer.parseInt(bf.readLine());
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            deg[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (deg[i] == 0) {
                res[i] = time[i];
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll(); // 현재 정점 now
            for (int i : arr[now]) { // now와 연결된 정점 i에 대해
                deg[i]--;
                res[i] = Math.max(res[now] + time[i], res[i]);
                if (deg[i] == 0) {
                    q.add(i);
                }
            }
        }
        int result = -1;
        for (int i=1; i<=n; i++) {
            result = Math.max(result, res[i]);
        }
        System.out.println(result);
    }
}