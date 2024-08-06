import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String input1, input2;
    public static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input1 = bf.readLine();
        input2 = bf.readLine();
        arr = new int[input1.length()+1][input2.length()+1];
        for (int i=1; i<=input1.length(); i++) {
            for (int j=1; j<=input2.length(); j++) {
                if (input1.charAt(i-1) == input2.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }
        lcs(input1.length(), input2.length());
        System.out.println(arr[input1.length()][input2.length()]);
        System.out.print(sb.reverse());
    }
    public static void lcs(int n, int m) {
        if (n == 0 || m == 0) return;
        if (input1.charAt(n-1) == input2.charAt(m-1)) {
            sb.append(input1.charAt(n-1));
            lcs(n-1, m-1);
        } else { // arr 배열에 저장된 값이 다르다면, 더 큰 값으로 이동.
            if (arr[n-1][m] > arr[n][m-1]) {
                lcs(n-1, m);
            } else {
                lcs(n, m-1);
            }
        }
    }
}