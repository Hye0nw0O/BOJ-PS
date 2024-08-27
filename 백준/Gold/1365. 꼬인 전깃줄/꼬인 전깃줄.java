import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lis[0] = arr[0];
        int len = 1;
        for (int i=1; i<n; i++) {
            if (lis[len-1] < arr[i]) { // lis 길이 증가.
                lis[len] = arr[i];
                len++;
            } else { // 선행 원소가 현재 lis 배열 마지막 원소보다 작은 경우
                int idx = bin(lis, 0, len, arr[i]);
                lis[idx] = arr[i];
            }
        }
        System.out.println(n - len);
    }
    public static int bin(int[] arr, int low, int high, int key) {
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                high = mid;
            } else { // arr[mid] < key
                low = mid + 1;
            }
        }
        return high;
    }
}