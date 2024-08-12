import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 9000009;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][n+1];
        for (int i=1; i<=n; i++) { Arrays.fill(arr[i], INF); }
        for (int i=1; i<=n; i++) { arr[i][i] = 0; }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u][v] = w; // 단방향
        }
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int c = Integer.parseInt(bf.readLine());
        int[] res = new int[c+1];
        int[][] arr2 = new int[c+1][n+1];
        st = new StringTokenizer(bf.readLine());
        for (int i=1; i<=c; i++) {
            res[i] = Integer.parseInt(st.nextToken());
        }
//        // 1~n의 도시에서 만나는 경우 거리 저장
        for (int z=1; z<=c; z++) {
            for (int i=1; i<=n; i++) {
                arr2[z][i] = arr[res[z]][i] + arr[i][res[z]];
            }
        }
        int[] result = new int[n+1];
        for (int i=1; i<=n; i++) {
            int tmp = -1;
            for (int j=1; j<=c; j++) {
                tmp = Math.max(tmp, arr2[j][i]);
            }
            result[i] = tmp;
        }
        // 1~n 도시에서 만나는 경우의 왕복 거리중 작은 것을 선택.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int dis = INF;
        for (int i=1; i<=n; i++) {
            dis = Math.min(dis, result[i]);
        }
        for (int i=1; i<=n; i++) {
            if (result[i] == dis) {
                pq.add(i);
            }
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}