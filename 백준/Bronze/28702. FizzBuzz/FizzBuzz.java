import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] arr = new String[3];
        int tmp = -1;
        int idx = -1;
        for (int i = 0; i < 3; i++) {
            arr[i] = bf.readLine();
            if (arr[i].contains("0") || arr[i].contains("1") || arr[i].contains("2") || arr[i].contains("3") || arr[i].contains("4") || arr[i].contains("5") || arr[i].contains("6") || arr[i].contains("7") || arr[i].contains("8") || arr[i].contains("9")) {
                tmp = Integer.parseInt(arr[i]);
                idx = i;
            }
        }
        int next = tmp + 3 - idx;
        if (next % 15 == 0) System.out.println("FizzBuzz");
        else if (next % 5 == 0) System.out.println("Buzz");
        else if (next % 3 == 0) System.out.println("Fizz");
        else System.out.println(next);
    }
}
