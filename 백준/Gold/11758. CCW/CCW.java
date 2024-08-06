import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        System.out.println(ccw(x1, y1, x2, y2, x3, y3));
    }
    public static int ccw (int x1, int y1, int x2, int y2, int x3, int y3) {
        double ccw = (x1*y2 + x2*y3 + x3*y1) - (x1*y3 + x2*y1 + x3*y2);
        if (ccw > 0) { return 1; } // 반시계 방향
        else if (ccw < 0) { return -1; } // 시계 방향
        else return 0; // 세 점은 일직선 상 위치
    }
}