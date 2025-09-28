import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] node_info;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        PriorityQueue<Node> set = new PriorityQueue<>();
        int n = Integer.parseInt(bf.readLine());
        node_info = new int [n+1];
        int[][] input = new int [n+1][n+1];
        for (int i=1; i<=n; i++) {
            node_info[i] = i;
            st = new StringTokenizer(bf.readLine());
            for (int j=1; j<=n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        int precnt = 0;
        for (int i=1; i<=n; i++) {
            for (int j=i; j<=n; j++) {
                if (input[i][j] == 0) {
                    continue;
                } else if (input[i][j] < 0) {
                    union(i, j);
                    precnt++;
                    result += input[i][j] * -1;
                } else {
                    pq.add(new Node(i, j, input[i][j]));
                }
            }
        }
        int cnt = 0;
        while (! pq.isEmpty()) {
            Node now = pq.poll();
            if (find(now.u) != find(now.v)) {
                result += now.w;
                cnt++;
                union(now.u, now.v);
                set.add(now);
            }
        }
        System.out.println(result + " " + cnt);
        while (! set.isEmpty()) {
            Node now = set.poll();
            System.out.println(now.u + " " + now.v);
        }
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            node_info[b] = a;
        }
    }
    public static int find(int a) {
        if (node_info[a] == a) {
            return a;
        } else {
            return node_info[a] = find(node_info[a]);
        }
    }
}
class Node implements Comparable<Node> {
    int u, v, w;
    public Node(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
    public int compareTo(Node n){
        return this.w - n.w;
    }
}