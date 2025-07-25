import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int [n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            if (! map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }

        }
        Arrays.sort(arr);
        int avg = 0;
        int mid = 0;
        int mode = 0;
        int range = 0;
        for (int i=0; i<n; i++) {
            avg += arr[i];
        }
        avg = Math.round((float) avg / n);
        mid = arr[n/2];

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int freq = list.get(0).getValue();
        List<Integer> mode_list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue() == freq) {
                mode_list.add(list.get(i).getKey());
            }
        }
        Collections.sort(mode_list);
        if (mode_list.size() == 1) {
            mode = mode_list.get(0);
        } else {
            mode = mode_list.get(1);
        }
        range = arr[n-1] - arr[0];
        System.out.println(avg);
        System.out.println(mid);
        System.out.println(mode);
        System.out.println(range);
    }
}