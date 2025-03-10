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
        int[] arr = new int [size];
        for (int i=0; i<size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bubble_sort(arr);
        if (cnt < k) {
            System.out.println(-1);
        } else {
            for (int i=0; i<size; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
    public static void bubble_sort (int[] arr) {
        cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                int tmp1 = arr[j];
                int tmp2 = arr[j+1];
                if (tmp1 > tmp2) {
                    arr[j+1] = tmp1;
                    arr[j] = tmp2;
                    cnt++;
                    if (cnt == k) {
                        return;
                    }

                }
            }
        }
    }
}