import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String[] arr =  {"BANANA", "PLUM", "LIME", "STRAWBERRY"};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            if (! map.containsKey(name)) {
                map.put(name, cnt);
            } else {
                map.put(name, map.get(name) + cnt);
            }
        }
        boolean res = false;
        for (int i=0; i < 4; i++) {
            if (map.get(arr[i]) != null)
                if (map.get(arr[i]) == 5)
                    res = true;
        }
        if (res) System.out.println("YES");
        else System.out.println("NO");
    }
}
