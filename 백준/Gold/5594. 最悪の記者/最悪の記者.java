import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] deg;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; //= new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        arr = new ArrayList[n+1];
        for (int i=1; i<=n; i++) { arr[i] = new ArrayList<>(); }
        deg = new int[n+1];
        int m = Integer.parseInt(bf.readLine());
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v); // 방향 그래프 연결
            deg[v]++; // 해당 정점의 진입 차수 증가.
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (deg[i] == 0) q.add(i);
        }
        int tmp;
        boolean check = true;
        while (! q.isEmpty()) {
            int now = q.poll();
            System.out.println(now);
            tmp = 0;
            for (int i : arr[now]) {
                deg[i]--;
                if (deg[i] == 0) {
                    tmp++;
                    q.add(i);
                }
            }
            if (tmp >= 2) check = false;
        }
        if (check) System.out.println(0);
        else System.out.println(1);
    }
}