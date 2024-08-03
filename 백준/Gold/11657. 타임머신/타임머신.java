import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static Edge[] arr;
    static long[] dis;
    static int INF = 99999999;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new Edge[m+1];
        dis = new long[n+1]; // 배열 크기 => 정점 개수
        Arrays.fill(dis, INF);
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new Edge(u, v ,w);
        }
        dis[1] = 0;
        for (int i=1; i<n; i++) { // n-1회 반복
            for (int j=0; j<m; j++) {
                Edge tmp = arr[j];
                if (dis[tmp.start] != INF && dis[tmp.end] > dis[tmp.start] + tmp.w) {
                    dis[tmp.end] = dis[tmp.start] + tmp.w;
                }
            }
        }
        boolean cycle = false;
        for (int i=0; i<m; i++) { // 마지막 루프에서 값이 업데이트 된다면, 사이클 존재.
            Edge tmp = arr[i];
            if (dis[tmp.start] != INF && dis[tmp.end] > dis[tmp.start] + tmp.w) {
                cycle = true;
            }
        }
        if (cycle) System.out.println(-1);
        else {
            for (int i=2; i<=n; i++) {
                if (dis[i] != INF) System.out.println(dis[i]);
                else System.out.println(-1);
            }
        }
    }
}
class Edge {
    int start, end, w;
    public Edge(int start, int end, int w) {
        this.start = start;
        this.end = end;
        this.w = w;
    }
}