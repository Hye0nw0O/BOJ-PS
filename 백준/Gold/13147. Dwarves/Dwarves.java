import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        ArrayList<Integer>[] arr = new ArrayList[10001];
        for (int i=1; i<arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] deg = new int [10001];
        int counter = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            String name1 = st.nextToken();
            String op = st.nextToken();
            String name2 = st.nextToken();
            if (! map.containsKey(name1)) {
                map.put(name1, counter);
                counter++;
            }
            if (! map.containsKey(name2)) {
                map.put(name2, counter);
                counter++;
            }
            if (op.equals(">")) {
                deg[map.get(name1)]++;
                arr[map.get(name2)].add(map.get(name1));
            } else if (op.equals("<")) {
                deg[map.get(name2)]++;
                arr[map.get(name1)].add(map.get(name2));
            }

        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<deg.length; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (! q.isEmpty()) {
            int now = q.poll();
            for (int i : arr[now]) {
                deg[i]--;
                if (deg[i] == 0) {
                    q.add(i);
                }
            }
        }
        boolean res = true;
        for (int i=1; i<deg.length; i++) {
            if (deg[i] != 0) {
                res = false;
                break;
            }
        }
        if (res) System.out.println("possible");
        else System.out.println("impossible");
    }
}