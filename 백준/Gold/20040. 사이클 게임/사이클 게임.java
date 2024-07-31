import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int res = n+1;
        for (int i=0; i<n; i++) { arr[i] = i; }
        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = find(Integer.parseInt(st.nextToken()));
            int b = find(Integer.parseInt(st.nextToken()));
            if (a != b) {
                arr[b] = a;
            } else {
                res = Math.min(res, i);
            }
        }
        if (res != n+1) System.out.println(res);
        else System.out.println(0);
    }

    public static int find(int n) {
        if (arr[n] == n) {
            return n;
        } else {
            return arr[n] = find(arr[n]);
        }
    }
}