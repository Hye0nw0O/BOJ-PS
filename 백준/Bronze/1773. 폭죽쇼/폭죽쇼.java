import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[] arr;
    public static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new boolean[c + 1];
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(bf.readLine());
            sol(t);
        }
        int cnt = 0;
        for (int i = 0; i <= c; i++) {
            if (arr[i]) cnt++;
        }
        System.out.println(cnt);
    }

    public static void sol(int n) {
        for (int i = 1; i <= c; i++) {
            if (i * n <= c)
                arr[i * n] = true;
            else
                break;
        }
        return;
    }
}