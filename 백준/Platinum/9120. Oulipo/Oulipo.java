import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i=0; i<n; i++) {
            cnt = 0;
            String ptr = bf.readLine();
            String txt = bf.readLine();
            Kmp(txt, ptr);
            System.out.println(cnt);
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
                    idx = table[idx];
                } else {
                    idx++;
                }
            }
        }
    }
}
