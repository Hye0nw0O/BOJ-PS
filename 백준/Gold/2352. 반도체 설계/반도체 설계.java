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
        for (int i=0; i<n; i++) { arr[i] = Integer.parseInt(st.nextToken()); }
        lis[0] = arr[0];
        int len = 1;
        for (int i=1; i<n; i++) {
            if (arr[i] > lis[len - 1]) { // 원소 추가
                lis[len] = arr[i];
                len++;
            } else { // 교체될 원소 idx 찾기 => use binary search
                int idx = bin(lis, 0, len, arr[i]);
                lis[idx] = arr[i];
            }
        }
        System.out.println(len);
    }
    public static int bin (int[] arr, int l, int h, int k) {
        int mid;
        while (l < h) {
            mid = (l + h) / 2;
            if (arr[mid] == k)
                return mid;
            if (arr[mid] > k) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }
}