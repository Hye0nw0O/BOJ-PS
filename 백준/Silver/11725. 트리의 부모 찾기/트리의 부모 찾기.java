import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] res;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        arr = new ArrayList[n+1];
        visit = new boolean[n+1];
        res = new int[n+1];
        for (int i=1; i<=n; i++) { arr[i] = new ArrayList<>(); }
        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        dfs(1);
        for (int i=2; i<=n; i++) {
            System.out.println(res[i]);
        }
    }
    public static void dfs(int n) {
        if (visit[n]) {
            return;
        }
        visit[n] = true;
        for (int i : arr[n]) { // n 노드에 연결된 자식 노드 i에 대해서 실행
            if (! visit[i]) {
                res[i] = n; // 따라서 i의 부모 노드는 n
                dfs(i);
            }
        }
    }
}