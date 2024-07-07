import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int [n+1]; // 1~ n-1
        for (int i=0; i<=n; i++) {
            arr[i] = i;
        }
        int p1 = 1, p2 = 1;
        int cnt = 1; // p2가 n이 아닐 때 까지 진행 -> n으로도 n을 표현 가능하므로 cnt = 1에서 시작.
        int sum = 1;
        while (p2 != n) {
            if (sum == n) {
                cnt++;
                sum -= arr[p1];
                p1++;
            } else if (sum > n) {
                sum -= arr[p1];
                p1++;
            } else {
                p2++;
                sum += arr[p2];
            }
        }
        System.out.println(cnt);
    }
}