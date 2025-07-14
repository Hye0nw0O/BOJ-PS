import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        if (! input.contains(".")) { // input에 .없는 경우
            if (input.length() % 2 == 0) {
                System.out.println(sol(input.length()));
                return;
            }
            else {
                System.out.println(-1);
                return;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> dot_list = new ArrayList<>();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X') {
                cnt++;
            } else { // 현재 문자가 .이면, 카운트 중단하고 현재까지 x 길이 저장
                if (cnt != 0) {
                    sb.append(sol(cnt));
                    cnt = 0;
                }
                sb.append(".");
            }
        }
        sb.append(sol(cnt));
        if (sb.toString().contains("-1")) System.out.println(-1);
        else System.out.println(sb);
        
    }
    public static String sol(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 != 0) {
            return "-1";
        }
        while (n > 0) {
            if (n >= 4) {
                sb.append("AAAA");
                n -= 4;
            }
            else if (n >= 2) {
                sb.append("BB");
                n -= 2;
            }
        }
        return sb.toString();
    }
}
