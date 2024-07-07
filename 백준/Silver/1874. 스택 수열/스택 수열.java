import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int n = Integer.parseInt(bf.readLine());
        int[] seq = new int [n];
        s2.push(-1);
        for (int i=0; i<n; i++) {
            seq[i] = Integer.parseInt(bf.readLine());
            s1.push(n-i);
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(!s1.isEmpty() || s2.peek() != -1) {
            if (s2.peek() != seq[i]) {
                sb.append("+\n");
                if (!s1.isEmpty())
                    s2.push(s1.pop());
                else {
                    System.out.println("NO");
                    System.exit(0);
                }
            } else {
                sb.append("-\n");
                s2.pop();
                i++;
            }

        }
        System.out.println(sb.deleteCharAt(sb.length()-1));
    }
}
