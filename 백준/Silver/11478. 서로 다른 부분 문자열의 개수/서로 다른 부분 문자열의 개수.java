import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = bf.readLine();
        HashSet<String> set = new HashSet<>();
        for (int i=0; i<str.length(); i++) {
            for (int j=i; j<str.length(); j++) {
                String sub = str.substring(i, j+1);
                set.add(sub);
            }
        }
        System.out.println(set.size());
    }
}

