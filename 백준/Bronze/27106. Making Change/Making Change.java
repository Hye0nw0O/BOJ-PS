import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int res = 100 - Integer.parseInt(bf.readLine());
        System.out.print(res / 25 + " ");
        res %= 25;
        System.out.print(res / 10 + " ");
        res %= 10;
        System.out.print(res / 5 + " ");
        res %= 5;
        System.out.print(res);
    }
}