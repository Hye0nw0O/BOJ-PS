import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int k;
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int size = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        selection_sort(arr);
        if (cnt < k) {
            System.out.println(-1);
        }
    }

    public static void selection_sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int max = arr[i]; int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (max < arr[j]) { // 가장 큰 값 찾기
                    max = arr[j];
                    index = j;
                }
            }
            if (max != arr[i]) {
                int tmp1 = arr[i];
                arr[i] = max;
                arr[index] = tmp1;
                cnt++;
                if (cnt == k) {
                    System.out.print(arr[index] + " " + max);
                    return;
                }
            }
        }
    }
}