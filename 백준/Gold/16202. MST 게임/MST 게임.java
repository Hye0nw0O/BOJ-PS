import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] info;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int turn = Integer.parseInt(st.nextToken());
        info = new int[n + 1];
        int[] res = new int[turn];
        List<Edge> list = new ArrayList<>();
        PriorityQueue<Edge> pq;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Edge(u, v, i + 1));
        }
        for (int tc = 0; tc < turn; tc++) {
            for (int i=1; i<=n; i++) {
                info[i] = i;
            }
            pq = new PriorityQueue<>(); // pq 초기화
            int edge_cnt = 0;
            int total = 0;
            for (int i=tc; i<list.size(); i++) {
                pq.add(list.get(i));  // i번째 간선부터 pq에 삽입
            }
            while(! pq.isEmpty()) {
                Edge now = pq.poll();
                if (find(now.u) != find(now.v)) {
                    union(now.u, now.v);
                    total += now.w;
                    edge_cnt++;
                }
                if (edge_cnt == n-1) break;
            }
            if (edge_cnt == n-1) res[tc] = total;
            else res[tc] = 0;
        }
        for (int i=0; i<turn; i++) {
            System.out.print(res[i] + " ");
        }
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            info[b] = a;
        }
    }
    public static int find(int a) {
        if (info[a] == a) {
            return a;
        } else {
            return info[a] = find(info[a]);
        }
    }
}

class Edge implements Comparable<Edge> {
    int u, v, w;
    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge e) {
        return this.w - e.w;
    }
}