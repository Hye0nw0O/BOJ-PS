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
        long res = 0;
        long[] sum = new long [n+1];
        sum[0] = 0;
        long[] mod = new long [m];

        st = new StringTokenizer(bf.readLine());
        for (int i=1; i<=n; i++) {
            int input = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + input;
            int tmp = (int) (sum[i] % m);
//            if (tmp == 0) {
//                res++;
//            }
            mod[tmp]++;
        }

        for (int i=0; i<m; i++) {
            if (mod[i] > 1) {
                res += ( mod[i]*(mod[i] - 1) / 2);
            }
        }
        System.out.println(res + mod[0]);
    }
}