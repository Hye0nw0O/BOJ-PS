import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int [n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        int res = -1;
        for (int i=n-1; i >= 2; i--) {
            if (arr[i] < arr[i-1] + arr[i-2]) {
                res = arr[i] + arr[i-1] + arr[i-2];
                break;
            }
        }
        System.out.println(res);
    }
}

