import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node>[] arr;
    static int[] dis;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[num].add(new Node(e, w));
            arr[e].add(new Node(num, w));
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            dis = new int[n+1];
            visit = new boolean[n+1];
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dfs(x);
            System.out.println(dis[y]);
        }
    }
    public static void dfs(int n) {
        visit[n] = true;
        for (Node i : arr[n]) {
            if (!visit[i.node_num]) {
                visit[i.node_num] = true;
                dis[i.node_num] = dis[n] + i.w;
                dfs(i.node_num);
            }
        }
    }
}
class Node {
    int node_num, w;
    public Node(int node_num, int w) {
        this.node_num = node_num;
        this.w = w;
    }
}