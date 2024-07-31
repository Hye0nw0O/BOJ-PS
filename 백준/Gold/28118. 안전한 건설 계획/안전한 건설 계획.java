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
        arr = new int[n+1];
        for (int i=1; i<=n; i++) arr[i] = i;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i=1; i<=n; i++) {
            find(i);
            set.add(arr[i]);
        }
        System.out.print(set.size() - 1);
    }
    public static void union(int a, int b) {
        a = find(a); b = find(b);
        if (a != b) {
            arr[b] = a;
        }
    }
    public static int find(int n) {
        if (arr[n] == n) return n;
        else
            return arr[n] = find(arr[n]);
    }
}