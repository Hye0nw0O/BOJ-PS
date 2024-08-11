import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] deg;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        for (int i=1; i<=n; i++) { arr[i] = new ArrayList<>(); }
        deg = new int[n+1];
        int m = Integer.parseInt(st.nextToken());
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            deg[v]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=1; i<=n; i++) {
            if (deg[i] == 0) pq.add(i);
        }
        while (!pq.isEmpty()) {
            int now = pq.poll(); // 낮은 번호 + 진입 차수 0인 문제부터 poll
            System.out.print(now + " ");
            for (int i : arr[now]) {
                deg[i]--;
                if (deg[i] == 0) {
                    pq.add(i);
                }
            }
        }

    }
}