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
        int n = Integer.parseInt(bf.readLine());
        arr = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        dep = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        dfs(1, 0); // 모든 노드의 깊이 구함.
        int m = Integer.parseInt(bf.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            find_parent(a, b);
        }
    }

    public static void find_parent(int x, int y) { // 노드의 부모 탐색
        while (dep[x] > dep[y]) {
            x = parent[x];
        }
        while (dep[x] < dep[y]) {
            y = parent[y];
        } // 두 노드 깊이 동일하게 조정
        // 조정 후에는 2가지 case 발생 가능. First case) 두 노드의 부모가 같은 상황 => 바로 두 노드중 하나 출력
        // Second case) 두 노드의 부모 노드가 서로 다름. => 아래 while 루프 통해 노드를 하나씩 올려가며 부모 노드가 같을 때 까지 반복.
        while (x != y) {
            x = parent[x];
            y = parent[y];
        }
        System.out.println(x); // 부모 노드가 같을 때 까지 조정하였으므로 x, y중 하나 출력.
    }

    public static void dfs(int s, int depth) {
        visit[s] = true;
        for (int i : arr[s]) { // s 노드에 연결된 노드 i에 대해 실행.
            if (visit[i]) continue;
            visit[i] = true;
            parent[i] = s; // i의 부모는 s
            dep[i] = depth + 1;
            dfs(i, depth + 1);
        }
    }
}