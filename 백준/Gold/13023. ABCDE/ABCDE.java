import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    static boolean res;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n];
        visit = new boolean[n];
        for (int i=0; i<n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        res = false;
        for (int i=0; i<n; i++) {
            dfs(i, 0); // 매 노드에서 깊이 0을 시작으로 깊이 우선 탐색 실행
            if (res) {
                break;
            }
        }
        if (res)
            System.out.println(1);
        else
            System.out.println(0);
    }
    public static void dfs(int n, int depth) {
        if (depth == 4 || res) { // 깊이 4 이상이면 문제 요구 조건 충족
            res = true;
            return;
        }
        visit[n] = true;
        for (int i : arr[n]) {
            if (!visit[i]) {
                dfs(i, depth+1); // 깊이 1 증가시켜 깊이 우선 탐색 실행
            }
        }
        visit[n] = false;
    }
}