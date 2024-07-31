import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] com;
    static boolean res;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        int tc = Integer.parseInt(bf.readLine());
        for (int z=0; z<tc; z++){
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new ArrayList[n + 1];
            com = new int[n + 1];
            res = true;
            for (int i = 1; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(bf.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u].add(v);
                arr[v].add(u);
            }

            for (int i = 1; i <= n; i++) {
                if (!res) break;
                if (com[i] == 0) {
                    bfs(i, 1);
                }
            }
            if (res) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static void bfs(int n, int var) {
        Queue<Integer> q = new LinkedList<>();
        com[n] = var;
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : arr[now]) {
                if (com[i] == 0) {
                    com[i] = com[now] * -1;
                    q.add(i);
                } else {
                    if (com[i] * com[now] != -1) {
                        res = false;
                        return ;
                    }
                }
            }
        }
    }
}
