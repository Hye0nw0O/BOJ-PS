import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int [n][m];
        for (int i=0; i<n; i++) {
            String input = bf.readLine();
            for (int j=0; j<m; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        int len = -1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (arr[i][j] == 1 && i>0 && j>0)
                    arr[i][j] = Math.min(arr[i-1][j], Math.min(arr[i][j-1], arr[i-1][j-1])) + arr[i][j];
                len = Math.max(len, arr[i][j]);
            }
        }
        System.out.println(len*len);
    }
}