import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n+1];
        for (int i=1; i<=n; i++) arr[i] = i;
        int m = Integer.parseInt(bf.readLine());
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=1; j<=n; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) { // input 1인 경우 i와 j를 union
                    union(i, j);
                }
            }
        }
        int[] check = new int [m];
        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<m; i++) {
            check[i] = find(Integer.parseInt(st.nextToken()));
        }
        int tmp = check[0];
        boolean result = true;
        for (int i=1; i<m; i++) {
            if (check[i] != tmp) {
                result = false;
                break;
            }
        }
        if (result) System.out.println("YES");
        else System.out.println("NO");
    }
    public static void union(int n, int m) {
        n = find(n); m = find(m);
        if (n != m) {
            arr[m] = n;
        }

    }
    public static int find(int n) {
        if (arr[n] == n) return n;
        else
            return arr[n] = find(arr[n]);
    }
}