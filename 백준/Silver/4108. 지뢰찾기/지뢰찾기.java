import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        while (true) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            arr = new int[n][m];
            res = new int[n][m];
            for (int i = 0; i < n; i++) {
                String input = bf.readLine();
                for (int j = 0; j < m; j++) {
                    if (input.charAt(j) != '.') {
                        arr[i][j] = -1;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == -1) continue; // 지뢰 칸 제외
                    // 상
                    int cnt = 0;
                    if (i - 1 >= 0) {
                        if (arr[i - 1][j] == -1) cnt++;
                    }
                    // 하
                    if (i + 1 < n) {
                        if (arr[i + 1][j] == -1) cnt++;
                    }
                    // 좌
                    if (j - 1 >= 0) {
                        if (arr[i][j - 1] == -1) cnt++;
                    }
                    // 우
                    if (j + 1 < m) {
                        if (arr[i][j + 1] == -1) cnt++;
                    }
                    if (i + 1 < n && j - 1 >= 0) {
                        if (arr[i + 1][j - 1] == -1) cnt++;
                    }
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        if (arr[i - 1][j - 1] == -1) cnt++;
                    }
                    if (i + 1 < n && j + 1 < m) {
                        if (arr[i + 1][j + 1] == -1) cnt++;
                    }
                    if (i - 1 >= 0 && j + 1 < m) {
                        if (arr[i - 1][j + 1] == -1) cnt++;
                    }
                    res[i][j] = cnt;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == -1) System.out.print("*");
                    else System.out.print(res[i][j]);
                }
                System.out.println();
            }

        }
    }
}