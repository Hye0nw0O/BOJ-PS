import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    static int[] dis;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int v = Integer.parseInt(bf.readLine());
        arr = new ArrayList[v+1];
        visit = new boolean[v+1];
        dis = new int[v+1];
        st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(bf.readLine());
        for (int i=1; i<=v; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[u].add(e);
            arr[e].add(u);
        }
        dfs(x);

        if (visit[y])
            System.out.println(dis[y]);
        else
            System.out.println(-1);
    }
    public static void dfs(int n) {
        visit[n] = true;
        for (int i : arr[n]) {
            if (!visit[i]) {
                visit[i] = true;
                dis[i] = dis[n] + 1;
                dfs(i);
            }
        }
    }
}
