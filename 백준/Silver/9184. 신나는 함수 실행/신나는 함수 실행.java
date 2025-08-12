import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        arr = new int[21][21][21];
        while (true) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + sol(a, b, c));
        }
    }
    public static int sol(int a, int b, int c) {
        if (a >= 0 && a < 21 && b >= 0 && b < 21 && c >= 0 && c < 21 && arr[a][b][c] != 0) {
            return arr[a][b][c];
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return arr[20][20][20] = sol(20, 20, 20);
        }
        if (a < b && b < c) {
            return arr[a][b][c] = sol(a, b, c-1) + sol(a, b-1, c-1) - sol(a, b-1, c);
        }
        return arr[a][b][c] = sol(a-1, b, c) + sol(a-1, b-1, c) + sol(a-1, b, c-1) - sol(a-1, b-1, c-1);

    }
}

