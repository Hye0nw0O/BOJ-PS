import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int [n][m];
        int cnt = 0;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int t = Integer.parseInt(bf.readLine());
        for (int i=0; i<n-2; i++) {
            for (int j=0; j<m-2; j++) {
                pq = new PriorityQueue<>();
                for (int x=i; x<=i+2; x++) {
                    for (int y=j; y<=j+2; y++) {
                        pq.add(arr[x][y]);
                    }
                }
                for (int x = 0; x < 4; x++) {
                    pq.poll();
                }
                if (pq.poll() >= t)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}