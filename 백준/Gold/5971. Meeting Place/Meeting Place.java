import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    static int[] dep;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        for (int i=1; i<=n; i++) { arr[i] = new ArrayList<>(); }
        visit = new boolean[n+1];
        dep = new int[n+1];
        parent = new int[n+1];
        for (int i=2; i<=n; i++) {
            int u = Integer.parseInt(bf.readLine());
            arr[i].add(u);
            arr[u].add(i);
        }
        dfs(1, 0);
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            System.out.println(fun(u, v));
        }
    }
    public static int fun(int a, int b) {
        if (a == b) return a;
        while (dep[a] > dep[b]) {
            a = parent[a];
        }
        while (dep[a] < dep[b]) {
            b = parent[b];
        }
        while (a != b) {
            a = parent[a]; b = parent[b];
        }
        return a;
    }
    public static void dfs (int n, int d) {
        visit[n] = true;
        for (int i : arr[n]) {
            if (visit[i]) continue;
            visit[i] = true;
            dep[i] = d+1;
            parent[i] = n; // n에 연결된 i에 대해 반복중 => i의 부모는 n
            dfs(i, d+1);
        }
    }
}