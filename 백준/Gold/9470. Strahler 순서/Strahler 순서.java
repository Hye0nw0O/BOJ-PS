import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] Strahler;
    static int[] deg;
    static int[] max;
    static int[] cnt;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        Queue<Integer> q;
        int tc = Integer.parseInt(bf.readLine());
        for (int z = 0; z < tc; z++) {
            q = new LinkedList<>();
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr = new ArrayList[m + 1];
            deg = new int[m + 1];
            max = new int[m + 1];
            cnt = new int[m + 1];
            Strahler = new int[m + 1];
            for (int i = 1; i <= m; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < p; i++) { // 간선 연결
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a].add(b);
                deg[b]++; // 진입 차수 증가.
            }
            for (int i = 1; i <= m; i++) { // 진입 차수 0이면 Strahler는 1
                if (deg[i] == 0) {
                    q.add(i);
                    Strahler[i] = 1;
                }
            }
            ArrayList<Integer>[] tmp = new ArrayList[m + 1];
            for (int i = 1; i <= m; i++) {
                tmp[i] = new ArrayList<>();
            }
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int next : arr[now]) { // now 노드와 연결된 노드의 진입 차수 감소.
                    deg[next]--;
                    if (max[next] == Strahler[now]) { // 근원 노드의 순서 값과 max 값이 같다면, cnt만 증가.
                        cnt[next]++;
                    } else { // 다른 경우
                        if (max[next] < Strahler[now]) { // now 노드의 Strahler 값이 더 크면, now의 값으로 변경하고 cnt 조정.
                            cnt[next] = 1;
                            max[next] = Strahler[now];
                        }
                    }
                    tmp[next].add(now); // next로 진입하는 노드 정보 저장
                    if (deg[next] == 0) {
                        q.add(next);
                        if (cnt[next] == 1) {
                            Strahler[next] = max[next];
                        } else {
                            Strahler[next] = max[next] + 1;
                        }
                    }
                }
            }
            System.out.println(k + " " + Strahler[m]);
        }
    }
}