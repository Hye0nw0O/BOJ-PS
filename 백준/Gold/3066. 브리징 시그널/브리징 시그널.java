import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        for (int z=0; z<tc; z++) {
            int n = Integer.parseInt(bf.readLine());
            int[] arr = new int [n];
            int[] LIS = new int [n];
            for (int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(bf.readLine());
            }
            int LIS_len = 1;
            LIS[0] = arr[0];
            for (int i=1; i<n; i++) {
                if (LIS[LIS_len - 1] < arr[i]) {
                    LIS[LIS_len] = arr[i];
                    LIS_len++;
                } else {
                    int idx = binary(LIS, 0, LIS_len, arr[i]);
                    LIS[idx] = arr[i];
                }
            }
            System.out.println(LIS_len);
        }
    }
    public static int binary(int[] arr, int low, int high, int key) {
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}