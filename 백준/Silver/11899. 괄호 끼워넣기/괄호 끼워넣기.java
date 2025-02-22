import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();
        String str = bf.readLine();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                if (st.isEmpty()) { cnt++; }
                else { st.pop(); }
            } else {
                st.push(ch);
            }
        }
        System.out.println(cnt + st.size());
    }
}