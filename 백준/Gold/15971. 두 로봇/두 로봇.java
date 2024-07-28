import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<node>[] arr;
    static int[] dis;
    static boolean[] visit;
    static int max = 0;
    static int start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        dis = new int[n+1];
        visit = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u].add(new node(v, w));
            arr[v].add(new node(u, w));
        }
        dfs(start);
        System.out.println(dis[end] - max);
    }
    public static void dfs(int n) {
        if (n == end) return;
        visit[n] = true;
        for (node i : arr[n]) {
            if (!visit[i.num]) {
                visit[i.num] = true;
                max = Math.max(max, i.w);
                dis[i.num] = dis[n] + i.w;
                dfs(i.num);
                if (visit[end]) return; // end 정점을 방문하여 dis가 업데이트 된 후, dfs 함수 종료
            }
        }
    }
}

class node {
    int num, w;
    public node (int num, int w) {
        this.num = num;
        this.w = w;
    }
}