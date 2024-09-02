import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());
        int ccw1 = CCW(x1, x2, x3, y1, y2, y3);
        int ccw2 = CCW(x1, x2, x4, y1, y2, y4);
        int ccw3 = CCW(x3, x4, x1, y3, y4, y1);
        int ccw4 = CCW(x3, x4, x2, y3, y4, y2);
        if ((ccw1 * ccw2) < 0 && (ccw3 * ccw4) < 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
    public static int CCW(long a1, long a2, long a3, long b1, long b2, long b3) {
        long res = (a1 * b2 + a2 * b3 + a3 * b1 ) - (a1 * b3 + a2 * b1 + a3 * b2);
        if (res > 0)
            return 1;
        else if (res < 0)
            return -1;
        else
            return 0;
    }
}