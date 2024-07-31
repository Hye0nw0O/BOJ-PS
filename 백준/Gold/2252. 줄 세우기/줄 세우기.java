import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 위상 정렬 => 방향 그래프의 정점을 방향 순으로 나열하는 것.
// 위상 정렬의 결과는 항상 같지 않음.
public class Main {
    static ArrayList<Integer>[] arr;
    static int[] deg; // 진입 차수 배열
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        deg = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(st.nextToken());
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            deg[b]++; // 정점의 진입 차수 증가
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (deg[i] == 0) { // 진입 차수가 0인 정점부터 삽입.
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll(); // 진입 차수 0인 노드 poll.
            System.out.print(now + " ");
            for (int i : arr[now]) { // 진입 차수 0인 노드와 연결된 노드에 대해 탐색.
                deg[i]--; // 진입 차수 1 감소
                if (deg[i] == 0) { // 감소한 진입 차수가 0인 경우, 큐에 삽입함. 이것을 큐가 empty할 때까지 반복.
                    q.add(i);
                }
            }
        }
    }
}