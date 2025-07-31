import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static HashSet<Integer> set;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        sb = new StringBuilder();
        set = new HashSet<>();
        for (int i = 0; i<n; i++) {
            String input = bf.readLine();
            String op = "";
            int num = -1;
            if (input.contains(" ")) {
                op = input.split(" ")[0];
                num = Integer.parseInt(input.split(" ")[1]);
            } else {
                op = input;
            }
            if (op.equals("add")) {
                add(num);
            } else if (op.equals("remove")) {
                remove(num);
            } else if (op.equals("check")) {
                check(num);
            } else if (op.equals("toggle")) {
                toggle(num);
            } else if (op.equals("all")) {
                all();
            } else if (op.equals("empty")) {
                empty();
            }
        }
        System.out.print(sb);
    }
    public static void add(int x) {
        set.add(x);
    }
    public static void remove(int x) {
        set.remove(x);
    }
    public static void check(int x) {
        if (set.contains(x)) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }
    public static void toggle(int x) {
        if (set.contains(x)) {
            set.remove(x);
        } else {
            set.add(x);
        }
    }
    public static void all() {
        set = new HashSet<>();
        for (int i=1; i<=20; i++) {
            set.add(i);
        }
    }
    public static void empty() {
        set = new HashSet<>();
    }
}