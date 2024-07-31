import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] com;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        arr = new ArrayList[n+1];
        com = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j=0; j<m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i].add(num);
                arr[num].add(i);
            }
        }
        for (int i=1; i<=n; i++) {
            if (com[i] == 0) {
                bfs(i, 1);
            }
        }
        StringBuilder sb1 = new StringBuilder(); int cnt1 = 0;
        StringBuilder sb2 = new StringBuilder(); int cnt2 = 0;
        for (int i=1; i<=n; i++) {
            if (com[i] == 1) {
                cnt1++;
                sb1.append(i).append(" ");
            } else {
                cnt2++;
                sb2.append(i).append(" ");
            }
        }
        System.out.println(cnt1);
        System.out.println(sb1);
        System.out.println(cnt2);
        System.out.println(sb2);
    }
    public static void bfs(int n, int var) {
        Queue<Integer> q = new LinkedList<>();
        com[n] = var;
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : arr[now]) {
                if (com[i] == 0) {
                    com[i] = com[now] * -1;
                    q.add(i);
                }
            }
        }
    }
}
