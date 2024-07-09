import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int [n];
        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long max = Long.MIN_VALUE;
        int p1=0; int p2 = p1+k-1;
        while (p2 < n) {
            long tmp=0;
            for (int i=p1;i<=p2;i++) {
                tmp += arr[i];
            }
            if (tmp > max) max = tmp;
            p1++;
            p2++;

        }
        System.out.println(max);
    }

}

