import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static double[][] arr;
    static double[][] dp; // dp[now][visit] => 현재 정점 now에서 visit 상태에서 아직 방문하지 않은 정점을 방문하는 최소 경로 저장.
    static int n;
    static int INF = 900000001;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(bf.readLine());
        arr = new double[n][n];
        dp = new double[n][(1 << n) - 1];
        for (int i = 0; i < n; i++) { // dp 테이블 -1로 초기화
            Arrays.fill(dp[i], -1);
        }
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }
        for (int i=0; i<n; i++) { // arr 테이블 정점간의 거리 초기화
            for (int j=0; j<n; j++) {
                if (i == j) { arr[i][j] =0; }
                Point p1 = list.get(i);
                Point p2 = list.get(j);
                arr[i][j] = dis(p1, p2);
            }
        }
        System.out.printf("%6f", TSP(0, 1)); // visit 값을 1로 설정하여, 0번 정점만을 현재 방문한 상태를 의미함.
    }
    public static double dis(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
    }
    public static double TSP(int now, int visit) { // 현재 정점 now. visit 매개변수는 현재 방문한 정점 정보를 비트로 표현.
        // 함수 종료 조건
        if (visit == (1 << n) - 1) { // now에서 모든 정점 방문 완료
            if (arr[now][0] == 0) { // now ~ 0 경로 없음
                return INF;
            } else { // now ~ 0 경로 존재
                return arr[now][0];
            }
        }
        if (dp[now][visit] != -1) // now 정점에서 visit 상태까지의 경로 가중치가 이미 존재 -> 해당 값 반환
            return dp[now][visit];
        dp[now][visit] = INF; // 없는 경우 INF로 초기화
        for (int next = 0; next<n; next++) {
            if (arr[now][next] == 0) {
                continue;
            }
            if ((visit & (1 << next)) == 1 << next) { // next 정점 방문한 상태
                continue;
            }
            dp[now][visit] = Math.min(dp[now][visit], arr[now][next] + TSP(next, visit | (1 << next)));
        }
        return dp[now][visit];
    }
}

class Point { // 좌표 저장
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}