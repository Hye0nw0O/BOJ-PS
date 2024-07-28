import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 이분 그래프 -> 연결된 정점을 서로 다른 색으로 구성할 수 있음. (=> 사이클 존재하면 이분 그래프 X)
public class Main {
    static ArrayList<Integer>[] arr;
    static int[] check;
    static boolean res;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(bf.readLine());
        for (int z=0; z<tc; z++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            arr = new ArrayList[n+1];
            check = new int[n+1];
            res = true;
            for (int i=1; i<=n; i++) {
                arr[i] = new ArrayList<>();
            }
            int m = Integer.parseInt(st.nextToken());
            for (int i=0; i<m; i++) {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u].add(v);
                arr[v].add(u);
            } // 그래프 추가
            for (int i=1; i<=n; i++) {
                if (!res) break;
                if (check[i] == 0) { // 아직 방문하지 않은 정점은 초기값이 0
                    bfs(i, 1);
                }
            }
            if (res) System.out.println("YES");
            else System.out.println("NO");
        }

    }
    public static void bfs (int n, int var) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = var;
        while (!q.isEmpty() && res) {
            int now = q.poll();
            for (int i : arr[now]) {
                if (check[i] == 0) { // now 정점과 연결된 i 정점이 아직 방문하지 않은 정점이라면,
                    q.add(i);
                    check[i] = check[now] * -1;
                } else if (check[now] * check[i] != -1) { // 방문된 정점인데 부호가 반대가 아니라면, 이분 그래프 X
                    res = false;
                    return;
                }
            }
        }
    }
}