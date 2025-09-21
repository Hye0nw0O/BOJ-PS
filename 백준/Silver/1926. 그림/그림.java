import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] X = {0, 0, 1, -1};
    public static int[] Y = {-1, 1, 0, 0};
    public static int[][] arr;
    public static boolean[][] visit;
    public static int n, m, res;
    public static Queue<Point> q;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int [n][m];
        visit = new boolean[n][m];
        q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        res = -1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (arr[i][j] != 0 && !visit[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        if (cnt == 0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            System.out.println(cnt);
            System.out.println(res);
        }
    }
    public static void bfs(int x, int y) {
        q.add(new Point(x, y));
        int area = 1;
        visit[x][y] = true;
        while(! q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int next_x = now.x + X[i];
                int next_y = now.y + Y[i];
                if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= m) {
                    continue;
                }
                if (arr[next_x][next_y] != 0 && !visit[next_x][next_y]) {
                    visit[next_x][next_y] = true;
                    q.add(new Point(next_x, next_y));
                    area++;
                }
            }
        }
        res = Math.max(area, res);
    }
}

class Point {
    int x; int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}