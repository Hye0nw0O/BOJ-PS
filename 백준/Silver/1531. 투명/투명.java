import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[][] arr = new int [101][101];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    arr[x][y]++;
                }
            }
        }
        int cnt = 0;
        for (int i=1; i<101; i++) {
            for (int j=1; j<101; j++) {
                if (arr[i][j] > m) cnt++;
            }
        }
        System.out.println(cnt);
    }
}