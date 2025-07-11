import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static ArrayList<Integer>[] list;
    public static boolean[] visit;
    public static int[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        visit = new boolean[n+1];
        dis = new int [n+1];
        for (int i = 1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        if (a == b) {
            System.out.println(0);
            return;
        }
        dis[a] = 0;
        bfs(a);
        if (visit[b]) System.out.println(dis[b]);
        else System.out.println(-1);
    }
    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        visit[n] = true;
        q.add(n);
        while(! q.isEmpty()) {
            int poll = q.poll();
            for (int i: list[poll]) {
                if (! visit[i]) {
                    visit[i] = true;
                    dis[i] = dis[poll] + 1;
                    q.add(i);
                }
            }
        }
    }
}
