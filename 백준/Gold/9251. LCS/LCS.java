import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bf.readLine();
        String input2 = bf.readLine();
        int[][] arr = new int[input1.length()+1][input2.length()+1];
        for (int i=1; i<=input1.length(); i++) {
            for (int j=1; j<=input2.length(); j++) {
                if (input1.charAt(i-1) == input2.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }
        System.out.println(arr[input1.length()][input2.length()]);
    }
}