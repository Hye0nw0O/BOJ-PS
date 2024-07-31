import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Node[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new Node[n+1];
        for (int i=1; i<=n; i++) {
            int input = Integer.parseInt(bf.readLine());
            arr[i] = new Node(i, input);
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
//            union(a, b);
            System.out.println(union(a, b));
        }
    }
    public static int union(int a, int b) {
        a = find(arr[a].num);
        b = find(arr[b].num);
        int sum = arr[a].cost + arr[b].cost;
        if (a != b) {
            arr[b].num = a;
            arr[a].cost = sum;
            arr[b].cost = sum;
            return sum;
        } else {
            return arr[a].cost;
        }
    }
    public static int find(int n) {
        if (arr[n].num == n) {
            return n;
        } else {
            return arr[n].num = find(arr[n].num);
        }
    }
}
class Node {
    int num, cost;
    public Node(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }
}