import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] deg;
    static int[] cost; // 건물 건설 소모 시간
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        arr = new ArrayList[n+1];
        deg = new int[n+1];
        cost = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(st.nextToken());
            cost[i] = w;
            while (true) {
                int input = Integer.parseInt(st.nextToken());
                if (input == -1) break;
                arr[input].add(i); // input -> i 방향
                deg[i]++; // 정점 i의 진입 차수 증가. 진입 차수: 해당 노드로 진입하는 가짓 수.
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (deg[i] == 0)
                q.add(i);
        }
        int[] res = new int[n+1]; // 우선 건설해야 하는 건물 건설 시간 포함하여, 건물 완성까지 소모 시간
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : arr[now]) {
                deg[i]--;
                res[i] = Math.max(res[i], res[now] + cost[now]);
                if (deg[i] == 0) { // 진입 차수 0으로 조정된 정점 q에 삽입.
                    q.add(i);
                }
            }
        }
        for (int i=1; i<=n; i++) {
            System.out.println(res[i] + cost[i]);
        }
    }
}