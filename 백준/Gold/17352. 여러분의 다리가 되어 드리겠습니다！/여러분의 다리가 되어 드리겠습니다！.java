import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n+1];
        for (int i=1; i<=n; i++) { arr[i] = i; }
        for (int i=0; i<n-2; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }
        for (int i=1; i<=n; i++) {
            find(i);
        }
        int idx1 = arr[1];
        int idx2 = -1;
        for (int i=2; i<=n; i++) {
            if (idx1 != arr[i]) {
                idx2 = i;
                break;
            }
        }
        System.out.print(idx1 + " " + idx2);
    }
    public static void union(int a, int b) {
        a = find(a); b = find(b);
        if (a != b) {
            arr[b] = a;
        }
    }
    public static int find(int n) {
        if (arr[n] == n)
            return n;
        else
            return arr[n] = find(arr[n]);
    }
}