import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // sol => 지구이 코드는 n번째 정점을 탐색하지 않고 있음. 따라서 n번째 정점을 거치는 것이 최단경로가 되게끔 배열을 구성. 아래 주석 해제시 오차 개수 확인 가능.
        int size = 100; // size = 100 기준 오차 크기 9702.
        int[][] arr = new int[size+1][size+1];
        int[][] copy = new int[size+1][size+1];
        for (int i=1; i<=size; i++) {
            for (int j=1; j<=size; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                    copy[i][j] = 0;
                } else if (i == size || j == size) {
                    arr[i][j] = 1;
                    copy[i][j] = 1;
                } else {
                    arr[i][j] = 9999;
                    copy[i][j] = 9999;
                }
            }
        }
        System.out.println(size);
        for (int i=1; i<=size; i++) {
            for (int j=1; j<=size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
//        int cnt = 0;
//        for (int k=1; k<=size; k++) {
//            for (int i=1; i<=size; i++) {
//                for (int j=1; j<=size; j++) {
//                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
//                }
//            }
//        }
//        for (int k=1; k<=size - 1; k++) {
//            for (int i=1; i<=size; i++) {
//                for (int j=1; j<=size; j++) {
//                    copy[i][j] = Math.min(copy[i][j], copy[i][k] + copy[k][j]);
//                }
//            }
//        }
//        for (int i=1; i<=size; i++) {
//            for (int j=1; j<=size; j++) {
//                if (arr[i][j] != copy[i][j]) {
//                    cnt++;
//                }
//            }
//        }
//        System.out.println(cnt);
    }
}