import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < n; tc++) {
            boolean check = true;
            String str = bf.readLine();
            Stack<Character> stack = new Stack<>();
            for (int i=0; i<str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push('(');
                } else { // ) 처리
                    if (stack.isEmpty()) {
                        check = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (check && stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }

    }
}