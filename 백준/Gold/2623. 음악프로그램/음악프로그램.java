import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] deg;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        deg = new int[n+1];
        for (int i=1; i<=n; i++) { arr[i] = new ArrayList<>(); }
        int m = Integer.parseInt(st.nextToken());
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] tmp = new int [num];
            for (int j=0; j<num; j++) {
                int input = Integer.parseInt(st.nextToken());
                tmp[j] = input;
            }
            for (int j=1; j<num; j++) {
                arr[tmp[j-1]].add(tmp[j]);
                deg[tmp[j]]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append("\n");
            for (int i : arr[now]) {
                deg[i]--;
                if (deg[i] == 0) {
                    q.add(i);
                }
            }
        }
        boolean res = true;
        for (int i=1; i<=n; i++) {
            if (deg[i] != 0) {
                res = false;
                break;
            }
        }
        if (res) System.out.print(sb);
        else System.out.print(0);
    }
}