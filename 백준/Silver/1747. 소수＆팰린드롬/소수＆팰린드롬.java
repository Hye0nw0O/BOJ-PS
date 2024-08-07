import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] prime = new int[2000001];
        for (int i=2; i<2000001; i++) { prime[i] = i; }
        for (int i=2; i<=Math.sqrt(2000001); i++) {
            if (prime[i] == 0) continue;
            for (int j=i+i; j<2000001; j = j + i) {
                prime[j] = 0;
            }
        }
        for (int i=n; i<2000001; i++) {
            if (prime[i] != 0) {
                if (pal(i)) { System.out.print(i); break; }
            }
        }
    }
    public static boolean pal(int a) {
        String s1 = Integer.toString(a);
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();
        return s1.equals(s2);
    }
}