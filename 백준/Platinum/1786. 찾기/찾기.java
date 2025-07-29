import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Queue<Integer> q = new LinkedList<>();
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());
        String txt = bf.readLine();
        String ptr = bf.readLine();
        Kmp(txt, ptr);
        System.out.println(cnt);
        for (int i=0; i<cnt; i++) {
            System.out.print(q.poll() + " ");
        }
    }
    public static int[] table(String pattern) {
        int[] arr = new int [pattern.length()];
        int idx = 0;
        for (int i=1; i<arr.length; i++) {
            while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = arr[idx - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(idx)) {
                idx++;
                arr[i] = idx;
            }
        }
        return arr;
    }
    public static void Kmp(String text, String pattern) {
        int[] table = table(pattern);
        int idx = 0;
        for (int i=0; i<text.length(); i++) {
            while (idx > 0 && text.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx - 1];
            }
            if (text.charAt(i) == pattern.charAt(idx)) {
                if (idx == pattern.length() - 1) {
                    cnt++;
                    q.add((i - idx + 1));
                    idx = table[idx];
                } else {
                    idx++;
                }
            }
        }
    }
}
