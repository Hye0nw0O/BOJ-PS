import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] chk;
    static boolean res;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        chk = new int[n+1];
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
        }
        for (int i=1; i<=n; i++) {
            if (chk[i] == 0) {
                bfs(i);
            }
        }
        if (res) System.out.println(1);
        else System.out.println(0);
    }
    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        chk[n] = 1;
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : arr[now]) {
                if (chk[i] == 0) { // chk 배열 값이 0이면 아직 방문 X
                    chk[i] = chk[now] * -1;
                    q.add(i);
                } else if (chk[i] != 0) {
                    if (chk[i] * chk[now] != -1) {
                        res = false;
                        return;
                    }
                }
            }
        }
    }
}