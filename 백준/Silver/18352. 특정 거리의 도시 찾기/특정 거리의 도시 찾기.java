import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] dis;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        visit = new boolean[n+1];
        dis = new int[n+1];
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        for (int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
        }
        bfs(start);
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            if (dis[i] == k) {
                sb.append(i).append("\n");
            }
        }
        if (sb.toString().isEmpty())
            System.out.print(-1);
        else
            System.out.print(sb);
    }
    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        visit[n] = true;
        q.add(n);
        while(!q.isEmpty()) {
            int now = q.poll();
            for (int i : arr[now]) {
                if (!visit[i]) {
                    visit[i] = true;
                    dis[i] = dis[now] + 1;
                    q.add(i);
                }
            }
        }
    }
}