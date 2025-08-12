import java.io.*;
import java.util.*;

public class Main {
    public static int cntW = 0;
    public static int cntB = 0;
    public static int [][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        board = new int [n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0,0,n);
        System.out.println(cntW);
        System.out.println(cntB);

    }
    public static void partition(int r, int c, int size) {
        if (check(r, c, size)) {
            if (board[r][c] == 0) {
                cntW++;
            } else
                cntB++;
            return;
        }
        int halfsize = size/2;
        partition(r, c, halfsize);
        partition(r, c+halfsize, halfsize);
        partition(r+halfsize, c, halfsize);
        partition(r+halfsize, c+halfsize, halfsize);
    }

    public static boolean check(int r, int c, int size) {
        int color = board[r][c];
        for (int i=r; i<r+size; i++) {
            for (int j=c; j<c+size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}