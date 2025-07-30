import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        char[] arr = input.toCharArray();
        boolean check = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '-') {
                check = true;
            }
            if (arr[i] == '+' && check) {
                arr[i] = '-';
            }
        }
        List<String> num = new ArrayList<>();
        List<Character> op = new ArrayList<>();
        StringBuilder temp_num = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '+' || arr[i] == '-') { // 연산자
                num.add(temp_num.toString());
                temp_num = new StringBuilder();
                op.add(arr[i]);
            } else {
                temp_num.append(arr[i]);
            }
        }
        num.add(temp_num.toString());
        int res = Integer.parseInt(num.get(0));
        for (int i=1; i<num.size(); i++) {
            if (op.get(i-1) == '-') {
                res -= Integer.parseInt(num.get(i));
            } else if (op.get(i-1) == '+') {
                res += Integer.parseInt(num.get(i));
            }
        }
        System.out.println(res);
    }
}