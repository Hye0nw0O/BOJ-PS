import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int m_x = 1001;
        int m_y = 1001;
        for (int i = 0; i< m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            m_x = Math.min(x, m_x);
            m_y = Math.min(y, m_y);
        }
        int res = 0;
        if (m_x == 0 || m_y == 0) {
            System.out.println(0);
            return;
        }

        if (m_y * 6 <= m_x) {
            res = m_y * n;
            System.out.println(res);
            return;
        }

        while (n >= 0) {
            if (n >= 6) {
                res += m_x;
                n -= 6;
            }
            if (n < 6) {
                break;
            }
        }
        int u_x = m_x;
        int u_y = m_y * n;
        System.out.println(res + Math.min(u_x, u_y));

    }
}
