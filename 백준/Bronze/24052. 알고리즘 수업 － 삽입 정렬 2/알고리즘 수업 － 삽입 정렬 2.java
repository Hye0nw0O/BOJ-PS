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
        int[] arr = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        insertion_sort(arr);
        if (cnt < k) {
            System.out.println(-1);
        } else {
            for (int i = 1; i <= size ; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void insertion_sort(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            int loc = i - 1;
            int newItem = arr[i];
            while (1 <= loc && newItem < arr[loc]) {
                arr[loc + 1] = arr[loc];
                cnt++;
                if (cnt == k) {
                    return;
                }
                loc--;
            }
            if (loc + 1 != i) {
                arr[loc + 1] = newItem;
                cnt++;
                if (cnt == k) {
                    return;
                }
            }
        }
    }
}