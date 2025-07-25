import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int sum = 0;
        int idx = -1;
        for (int i=0; i<13; i++) {
            if (str.charAt(i) == '*') {
                idx = i;
                continue;
            }
            if (i % 2 == 0) {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            } else {
                sum += Integer.parseInt(String.valueOf(str.charAt(i))) * 3;
            }
        }
        if (idx % 2 == 0) System.out.println(10 - sum % 10);
        else {
            for (int i=0; i<10; i++) {
                if (((i * 3) + sum) % 10 == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
