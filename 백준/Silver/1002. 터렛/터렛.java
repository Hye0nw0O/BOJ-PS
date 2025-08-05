import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(bf.readLine());
        for (int x=0; x<tc; x++) {
            st = new StringTokenizer(bf.readLine());
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double r1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double r2 = Double.parseDouble(st.nextToken());

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
                continue;
            }

            double z_pow = Math.pow((x1 - x2) , 2) + Math.pow((y1 - y2) , 2);
            double z = Math.sqrt(z_pow);
            if (z_pow == 0) { // 두 점 사이 거리가 0,
                System.out.println(0);
                continue;
            }

            double hyp = Math.max(r1, Math.max(r2, z));
            if (hyp == r1) {
                if (z + r2 > hyp) System.out.println(2);
                else if (z + r2 == hyp) System.out.println(1);
                else if (z + r2 < hyp) System.out.println(0);
            } else if (hyp == r2) {
                if (z + r1 > hyp) System.out.println(2);
                else if (z + r1 == hyp) System.out.println(1);
                else if (z + r1 < hyp) System.out.println(0);
            } else if (hyp == z) {
                if (r1 + r2 > hyp) System.out.println(2);
                else if (r1 + r2 == hyp) System.out.println(1);
                else if (r1 + r2 < hyp) System.out.println(0);
            }
        }
    }
}