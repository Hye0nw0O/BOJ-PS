import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int arr[][] = new int [n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(arr[i], 9900001);
        }
        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1; // u에서 v로
            int w = Integer.parseInt(st.nextToken()); // 가중치 값 w

            arr[u][v] = Math.min(arr[u][v], w);

        }
        for (int i=0; i<n; i++) {
            arr[i][i] = 0;
        }

        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]); // [i][k]+[k][j] => Integer.MAX_VALUE의 경우 오버플로우 발생 가능
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j] != 9900001) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }



    }
}
