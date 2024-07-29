import java.io.*;
import java.util.*;

public class Main {
    static int arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int [n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (order == 0) {
                union(a, b);

            } else if (order == 1) {
                if (check(a, b)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
    public static int find(int x) {
        if (x == arr[x]) {
            return x;
        } else
            return arr[x] = find(arr[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            arr[b] = a;
        }
    }

    public static boolean check(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            return false;
        } else {
            return true;
        }
    }

}
