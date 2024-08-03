import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] deg;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        arr = new ArrayList[n+1];
        deg = new int[n+1];
        cost = new int[n+1];
        for (int i=1; i<=n; i++) { arr[i] = new ArrayList<>(); }
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(bf.readLine());
            int time = Integer.parseInt(st.nextToken());
            cost[i] = time;
            int input = Integer.parseInt(st.nextToken());
            int[] tmp_arr = new int[input+1];
            for (int j=1; j<=input; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                tmp_arr[j] = tmp;
            }
            for (int j=1; j<=input; j++) {
                arr[tmp_arr[j]].add(i);
                deg[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] tmp_cost = new int [n+1];
        for (int i=1; i<=n; i++) {
            if (deg[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int now = q.poll();
            for (int i : arr[now]) {
                deg[i]--;
                tmp_cost[i] = Math.max(tmp_cost[i], tmp_cost[now] + cost[now]);
                if (deg[i] == 0) {
                    q.add(i);
                }
            }
        }
        int[] res = new int [n+1];
        for (int i=1; i<=n; i++) {
            res[i] = tmp_cost[i] + cost[i];
        }
        Arrays.sort(res);
        System.out.print(res[n]);
    }
}