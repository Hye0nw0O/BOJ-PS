import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(bf.readLine());
        for (int z=0; z<tc; z++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] stock = new int[n];
            st = new StringTokenizer(bf.readLine());
            for (int i=0; i<n; i++) {
                stock[i] = Integer.parseInt(st.nextToken());
            }
            int[] arr = new int[n];
            arr[0] = stock[0];
            int len = 1;
            for (int i=1; i<n; i++) {
                if (arr[len-1] < stock[i]) {
                    arr[len] = stock[i];
                    len++;
                } else { // 삽입할 위치 탐색
                    int idx = Bin(arr, 0, len, stock[i]);
                    arr[idx] = stock[i];
                }
            }
            System.out.println("Case #" + (z+1));
            if (len >= k) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
    public static int Bin(int[] arr, int low, int high, int key) {
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