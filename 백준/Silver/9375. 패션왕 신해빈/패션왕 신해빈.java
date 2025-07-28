import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        for (int x=0; x<tc; x++) {
            int n = Integer.parseInt(bf.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i<n; i++) {
                String input = bf.readLine();
                String name = input.split(" ")[0];
                String type = input.split(" ")[1];

                if (! map.containsKey(type)) {
                    map.put(type, 1);
                } else {
                    map.put(type, map.get(type) + 1);
                }
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            List<Integer> sol = new ArrayList<>();
            for (int i=0; i<list.size(); i++) {
                sol.add(list.get(i).getValue());
            }
            System.out.println(solution(sol));
        }
    }
    public static int solution(List<Integer> list) {
        int res = 1;
        for (int i = 0; i < list.size(); i++) {
            res = res * (list.get(i) + 1);
        }
        return res - 1;
    }
}
