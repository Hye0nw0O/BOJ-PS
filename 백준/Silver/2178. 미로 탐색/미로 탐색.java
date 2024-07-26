import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int arr[][];
    static boolean visit[][];
    static int m, n;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken()); // m*n 배열에서 실행
        arr = new int[m][n];
        visit = new boolean[m][n];
        for (int i=0; i<m; i++) {
            String input = bf.readLine();
            for (int j=0; j<n; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        visit[0][0] = true;
        bfs(0,0);
        System.out.println(arr[m-1][n-1]);
    }

    public static void bfs(int sX, int sY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sX, sY});
        visit[sX][sY] = true;
        int[] X = {0, 0, 1, -1};
        int[] Y = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + X[i];
                int y = poll[1] + Y[i];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                if (visit[x][y] || arr[x][y] == 0) {
                    continue;
                }
                q.offer(new int[]{x, y});
                visit[x][y] = true;
                arr[x][y] = arr[poll[0]][poll[1]] +1;
            }

        }
    }
}
