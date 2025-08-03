import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] arr;
    public static boolean[][] visit;
    public static int[] X = {0, 0, 1, -1};
    public static int[] Y = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(bf.readLine());
        arr = new int [n][n];
        visit = new boolean[n][n];
        int max = -1;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i][j], max);
            }
        }
        int cnt = 0;
        int res = -1;
        for (int x = 0; x <= max; x++) {
            cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && arr[i][j] > x) {
                        sol(i, j, x);
                        cnt++;
                    }
                }
            }
            res = Math.max(res, cnt);
            visit = new boolean[n][n];
        }
        System.out.println(res);
    }
    public static void sol(int x, int y, int z) {
        visit[x][y] = true;
        for (int i=0; i<4; i++) {
            int next_x = x + X[i];
            int next_y = y + Y[i];
            if (next_x < 0 || next_y < 0 || next_x >= n || next_y >= n) { // 범위 확인
                continue;
            }
            if (arr[next_x][next_y] > z && !visit[next_x][next_y]) { // 침수 x + 미방문
                sol(next_x, next_y, z);
            }
        }
    }
}