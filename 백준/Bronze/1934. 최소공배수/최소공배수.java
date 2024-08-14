import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(bf.readLine());
        for (int i=0; i<tc; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int GCD = GCD(a, b);
            System.out.println(GCD * a/GCD * b/GCD);
        }
    }
    public static int GCD(int n, int k) {
        int min = Math.min(n, k); int max = Math.max(n, k);
        while (true) {
            int tmp = max % min;
            if (tmp == 0) {
                return min;
            }
            max = min;
            min = tmp;
        }
    }
}