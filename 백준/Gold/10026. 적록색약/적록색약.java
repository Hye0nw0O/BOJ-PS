import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] X = {0, 0, 1, -1};
    public static int[] Y = {1, -1, 0, 0};
    public static int n;
    public static char[][] arr;
    public static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(bf.readLine());
        int cnt = 0;
        int cnt2 = 0;
        arr = new char[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            for (int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    sol(i, j);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    sol(i, j);
                    cnt2++;
                }
            }
        }
        System.out.println(cnt + " " + cnt2);
    }

    public static void sol(int i, int j) {
        visit[i][j] = true;
        char now_color = arr[i][j]; // 현재 칸 색상
        visit[i][j] = true; // 방문 완료
        for (int a = 0; a < 4; a++) {
            int next_x = i + X[a];
            int next_y = j + Y[a];
            if (next_x < 0 || next_y < 0 || next_x >= n || next_y >= n) {
                continue;
            }
            if (!visit[next_x][next_y] && arr[next_x][next_y] == now_color) {
                sol(next_x, next_y);
            }
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}