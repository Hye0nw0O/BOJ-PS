import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int [n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int i=0; i<n; i++) {
            int find = arr[i];
            int p1 = 0; int p2 = n-1;
            while (p1 != p2) {
                if (arr[p1] + arr[p2] > find) {
                    p2--;
                } else if (arr[p1] + arr[p2] < find) {
                    p1++;
                } else {
                    if (p1 != i && p2 != i) {
                        cnt++;
                        break;
                    } else if (p1 == i) {
                        p1++;
                    } else if (p2 == i){
                        p2--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}