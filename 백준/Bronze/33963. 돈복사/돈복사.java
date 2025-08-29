import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long n = Long.parseLong(bf.readLine());
        long len = Long.toString(n).length();
        int cnt = 0;
        while (true) {
            if (Long.toString(n * 2).length() == len) {
                n *= 2;
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
}

