import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        visit = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int e = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            arr[e].add(u);
            arr[u].add(e);
        }
        for (int i=1; i<=n; i++) {
            Collections.sort(arr[i]);
        }
        dfs(v);
        visit = new boolean[n+1];
        System.out.println();
        bfs(v);
    }
    public static void dfs (int n) {
        System.out.print(n + " ");
        if (visit[n]) {
            return;
        }
        visit[n] = true;
        for (int i : arr[n]) {
            if (!visit[i])
                dfs(i);
        }
    }
    public static void bfs (int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int i : arr[now]) {
                if (!visit[i]) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}