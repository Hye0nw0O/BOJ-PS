import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        res = new int[n + 1];
        Arrays.fill(res, -1);
        int size = n;
        for (int i = 1; i <= n; i++) {
            int next_idx = size - arr[i];
            if (i == 1) {
                res[size - next_idx + 1] = i;
                size--;
                continue;
            }
            int cnt = next_idx;
            for (int x = res.length - 1; x >= 1; x--) {
                if (res[x] == -1) {
                    cnt--;
                } else {
                    continue;
                }
                if (cnt == 0) {
                    res[x] = i;
                }
            }
            size--;
        }
        for (int i=1; i<=n; i++) {
            System.out.print(res[i] + " ");
        }

    }
}