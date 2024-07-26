import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer [n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        int res = 0;
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i=0; i<n; i++) {
            if (arr[i] > k) { continue; }
            res += k / arr[i];
            k %= arr[i];
        }
        System.out.println(res);
    }

}