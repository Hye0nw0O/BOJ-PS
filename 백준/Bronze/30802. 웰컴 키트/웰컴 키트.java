import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[6];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int res_t = 0;
        for (int i=0; i<6; i++) {
            if (arr[i] % t == 0) {
                res_t += arr[i] / t;
            } else {
                res_t += (arr[i] / t) + 1;
            }
        }
        System.out.println(res_t);
        System.out.println(n / p + " " + n % p);
    }
}
