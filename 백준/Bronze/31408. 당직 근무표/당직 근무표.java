import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int [100001];
        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<n; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[input]++;
        }
        int max = -1;
        int sum = 0;
        for (int i=1; i<arr.length; i++) {
            max = Math.max(arr[i], max);
            sum += arr[i];
        }
        sum = sum - max;
        if (max - 1 <= sum) System.out.println("YES");
        else System.out.println("NO");
    }
}