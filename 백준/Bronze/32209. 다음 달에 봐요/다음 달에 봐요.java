import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        int quest = 0;
        boolean result = true;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            int q = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (q == 1) {
                quest += num;
            } else {
                if (quest < num) {
                    result = false;
                } else {
                    quest -= num;
                }
            }
        }
        if (result) System.out.println("See you next month");
        else System.out.println("Adios");
    }
}

