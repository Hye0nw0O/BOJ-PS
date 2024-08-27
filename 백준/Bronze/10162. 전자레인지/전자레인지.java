import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        if (n % 10 != 0) {
            System.out.println(-1);
            System.exit(0);
        }
        int a = 0, b = 0, c = 0;
        while (n != 0) {
            if (n >= 300) {
                a = n / 360;
                n %= 360;
            } else if (n >= 60) {
                b = n / 60;
                n %= 60;
            } else {
                c = n / 10;
                n %= 10;
            }
        }
        System.out.print(a + " " + b + " " + c);
    }
}