import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr;
        boolean check;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String str = bf.readLine();
            if (str.length() == 1) { // 1글자는 체크 불필요
                cnt++;
                continue;
            }
            check = true; arr = new int[26];
            arr[str.charAt(0) - 'a']++;
            for (int x = 1; x < str.length(); x++) {
                if (str.charAt(x) != str.charAt(x - 1)) { // 바로 옆글자가 다른 경우
                    if (arr[str.charAt(x) - 'a'] == 0) { // 등장 x
                        arr[str.charAt(x) - 'a']++;
                    } else { // 등장 o
                        check = false;
                        break;
                    }
                }
            }
            if (check) cnt++;
        }
        System.out.println(cnt);
    }
}