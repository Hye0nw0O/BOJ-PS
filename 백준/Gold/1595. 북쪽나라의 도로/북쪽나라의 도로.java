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
        StringTokenizer st;
        String input;
        arr = new ArrayList[10001];
        dis = new int[10001];
        visit = new boolean[10001];
        for (int i=1; i<10001; i++) { arr[i] = new ArrayList<>(); }
        while ((input = bf.readLine()) != null) {
            st = new StringTokenizer(input);
            if (!st.hasMoreTokens()) break;
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u].add(new Node(v, w));
            arr[v].add(new Node(u, w));
        }
        dfs(1);
        int maxidx = 1;
        for (int i=2; i<10001; i++) {
            if (dis[maxidx] < dis[i]) {
                maxidx = i;
            }
        }
        dis = new int[10001];
        visit = new boolean[10001];
        dfs(maxidx);
        int maxdis = -1;
        for (int i=1; i<10001; i++) {
            maxdis = Math.max(maxdis, dis[i]);
        }
        System.out.println(maxdis);
    }
    public static void dfs(int start) {
        visit[start] = true;
        for (Node i : arr[start]) {
            if (visit[i.n]) continue;
            visit[i.n] = true;
            dis[i.n] = dis[start] + i.w;
            dfs(i.n);
        }
    }
}
class Node {
    int n, w;
    public Node (int n, int w) {
        this.n = n;
        this.w = w;
    }
}