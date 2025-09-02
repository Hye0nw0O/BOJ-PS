import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long [n];
        long[] sum = new long [n];
        long[] x = new long [m]; // 결과 count 위한 배열
        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 0) {
                sum[i] = arr[i];
            } else {
                sum[i] = sum[i-1] + arr[i];
            }
        }
        long[] mod = new long [n]; // 구간 합 나머지 저장
        long cnt = 0;
        for (int i=0; i<n; i++) {
            mod[i] = sum[i] % m;
            x[(int)mod[i]]++;
            if (mod[i] == 0) cnt++;
        }
        for (int i=0; i<m; i++) {
            cnt += x[i] * (x[i] - 1) / 2;
        }
        System.out.println(cnt);

    }
}

