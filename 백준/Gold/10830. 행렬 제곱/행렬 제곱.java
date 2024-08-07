import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] mat;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        mat = new int [n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<n; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        int[][] res = pow(mat, b);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] pow(int[][] matrix, long exp) {
        if (exp == 1) { return matrix; } // 지수가 1이라면 matrix 행렬 반환
        int[][] arr = pow(matrix, exp / 2); // 지수를 반으로 나누어 재귀 호출.
        arr = mul(arr, arr); // arr * arr

        if (exp % 2 != 0) { // 지수가 홀수였다면, 원본 행렬을 한번 더 곱해줌.
            arr = mul(arr, mat);
        }
        return arr; // 다 곱해진 행렬 arr 반환
    }
    public static int[][] mul(int[][] arr1, int[][] arr2) {
        int[][] arr = new int [n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                    arr[i][j] %= 1000;
                }
            }
        }
        return arr;
    }
}