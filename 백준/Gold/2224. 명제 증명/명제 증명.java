import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int [52][52]; // 알파벳 개수만큼의 배열.
        for (int i=0; i<52; i++) { Arrays.fill(arr[i], INF); }
        for (int i=0; i<52; i++) { arr[i][i] = 0; }
        int tmp1, tmp2;
        for (int i=0; i<n; i++) {
            String[] input = bf.readLine().split(" "); // 공백 기준 분리
            tmp1 = 0; tmp2 = 0;
            if (input[0].charAt(0) - 97 >= 0) { // 소문자
                tmp1 = input[0].charAt(0) - 71;
            } else { // 대문자
                tmp1 = input[0].charAt(0) - 65;
            }
            if (input[2].charAt(0) - 97 >= 0) {
                tmp2 = input[2].charAt(0) - 71;
            } else {
                tmp2 = input[2].charAt(0) - 65;
            }
            arr[tmp1][tmp2] = 1;
        }
        for (int k=0; k<52; k++) {
            for (int i=0; i<52; i++) {
                for (int j=0; j<52; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<52; i++) {
            for (int j=0; j<52; j++) {
                if (i == j) continue;
                if (arr[i][j] != INF) {
                    cnt++;
                    int t1 = i, t2 = j;
                    if (t1 >= 26) t1 += 71;
                    else t1 += 65;
                    if (t2 >= 26) t2 += 71;
                    else t2 += 65;
                    sb.append((char)t1).append(" => ").append((char)t2).append("\n");
                }
            }
        }
        System.out.println(cnt);
        System.out.print(sb);


    }
}