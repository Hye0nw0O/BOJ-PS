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
        StringTokenizer st;
        int tc = Integer.parseInt(bf.readLine());
        for (int z=0; z<tc; z++) {
            int n = Integer.parseInt(bf.readLine());
            arr = new ArrayList[n+1];
            visit = new boolean[n+1];
            dep = new int[n+1];
            parent = new int[n+1];
            for (int i=1; i<=n; i++) { arr[i] = new ArrayList<>(); }
            for (int i=0; i<n-1; i++) {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u].add(v);
                arr[v].add(u);
                visit[v] = true;
            }
            int root = -1;
            for (int i=1; i<=n; i++) {
                if (!visit[i]) {
                    root = i;
                    break;
                }
            }
            visit = new boolean[n+1];
            dfs(root, 0);
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            find_par(a, b);
        }
    }
    public static void find_par(int x, int y) {
        while (dep[x] > dep[y]) {
            x = parent[x];
        }
        while (dep[x] < dep[y]) {
            y = parent[y];
        } // 두 노드의 부모 노드의 깊이가 동일하게 설정
        while (x != y) {
            x = parent[x]; y = parent[y];
        }
        System.out.println(x);
    }
    public static void dfs(int s, int depth) {
        visit[s] = true;
        for (int i : arr[s]) {
            if (visit[i]) continue;
            parent[i] = s;
            visit[i] = true;
            dep[i] = depth + 1;
            dfs(i, depth + 1);
        }
    }
}