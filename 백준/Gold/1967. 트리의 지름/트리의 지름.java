import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<node>[] arr;
    static int[] dis;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        arr = new ArrayList[n+1];
        dis = new int[n+1];
        visit = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[e].add(new node(v, w));
            arr[v].add(new node(e, w));
        }
        int idx = 1;
        dfs(1);
        for (int i=2; i<=n; i++) {
            if (dis[idx] < dis[i]) {
                idx = i;
            }
        }
        dis = new int[n+1];
        visit = new boolean[n+1];
        dfs(idx);
        Arrays.sort(dis);
        System.out.print(dis[n]);
    }
    public static void dfs(int n) {
        visit[n] = true;
        for (node i : arr[n]) {
            if (!visit[i.num]) {
                visit[i.num] = true;
                dis[i.num] = dis[n] + i.w;
                dfs(i.num);
            }
        }
    }
}

class node {
    int num, w;
    public node (int num, int w) {
        this.num = num;
        this.w = w;
    }
}