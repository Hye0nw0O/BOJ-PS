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
        int[] arr = new int[m+1];
        for (int i=1; i<=m; i++) { arr[i] = i; }
        arr[1] = 0;
        for (int i=2; i<=Math.sqrt(m); i++) {
            if (arr[i] == 0) continue;
            for (int j=i+i; j<=m; j = j+i) {
                arr[j] = 0; // 인덱스 값이 i의 배수이면 그 값을 0으로 변경.
            }
        }
        for (int i=n; i<=m; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}