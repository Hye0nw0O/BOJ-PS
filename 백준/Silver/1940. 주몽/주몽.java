import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int[] arr = new int [n];
        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int p1 = 0, p2 = n-1, cnt = 0;
        while (p1 != p2) {
            int tmp = arr[p1] + arr[p2];
            if (tmp < m) p1++;
            else {
                if (tmp == m) cnt++;
                p2--;
            }
        }
        System.out.println(cnt);
    }
}
