import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int cnt_0;
    public static int cnt__1;
    public static int cnt_1;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        cnt_0 = 0;
        cnt__1 = 0;
        cnt_1 = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol(0, 0, n);
        System.out.println(cnt__1);
        System.out.println(cnt_0);
        System.out.println(cnt_1);
    }

    public static void sol(int x, int y, int size) {
        if (check(x, y, size)) {
            if (arr[x][y] == -1) {
                cnt__1++;
            } else if (arr[x][y] == 0) {
                cnt_0++;
            } else if (arr[x][y] == 1) {
                cnt_1++;
            }
            return;
        }
        int next_size = size / 3;
        sol(x, y, next_size);
        sol(x + next_size, y, next_size);
        sol(x + next_size * 2, y, next_size);

        sol(x, y + next_size, next_size);
        sol(x + next_size, y + next_size, next_size);
        sol(x + next_size * 2, y + next_size, next_size);

        sol(x, y + next_size * 2, next_size);
        sol(x + next_size, y + next_size * 2, next_size);
        sol(x + next_size * 2, y + next_size * 2, next_size);
    }

    public static boolean check(int x, int y, int size) {
        int num = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}

