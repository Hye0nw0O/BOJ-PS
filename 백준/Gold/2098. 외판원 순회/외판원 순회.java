import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] dp;
    static int n;
    static int INF = 900000001;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        dp = new int [n][(1<<n) - 1];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(fun(0, 1)); // visit 값을 1로 설정하여, 0번 정점만을 현재 방문한 상태를 의미함.
    }
    public static int fun (int now, int visit) { // 현재 정점 now. visit 매개변수는 현재 방문한 정점 정보.
        if (visit == (1 << n) - 1) { // 1 << n == 2^n
        // 함수 종료: 0 ~ n-1번째 정점을 방문하였다면, 모든 정점을 방문한 것. 따라서 현재 정점 now에서 0번째 정점으로 돌아와야 함.
            if (arr[now][0] == 0) { // now 정점에서 0번 정점으로 돌아오는 경로가 없는 경우.
                return INF;
            } else { // now 정점에서 0번 정점으로 돌아오는 값이 존재함. 즉, now -> 0번 정점을 연결하는 경로가 존재함.
                return arr[now][0];
            }
        }
        if (dp[now][visit] != -1) { // now -> visit으로 가는 경로를 이미 구한 경우에는,
            return dp[now][visit]; // now -> visit의 가중치를 반환.
        }
        // now -> visit으로 향하는 경로를 아직 구하지 않았으므로, 아래 과정을 통해 해당 경로를 구해야 함.
        // 따라서 INF로 초기화.
        dp[now][visit] = INF;

        for (int next = 0; next < n; next++) {
            if (arr[now][next] == 0) { // now -> next 경로가 없음
                continue;
            }
            if ((visit & (1 << next)) == 1 << next) {// 방문 여부 판정
                continue;
            }
            // 현재 정점 now에서 visit의 정점을 방문한 상태에서, 남은 정점을 순회하는 최소 비용 vs now -> next 정점 이동 비용 + visit 상태의 정점을 방문하고 남은 정점을 순회하는 경우의 최솟값
            dp[now][visit] = Math.min(dp[now][visit], arr[now][next] + fun(next, visit | (1 << next)));
        }
        return dp[now][visit];
    }
}