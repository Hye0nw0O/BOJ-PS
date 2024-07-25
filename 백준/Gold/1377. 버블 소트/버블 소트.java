import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        boj[] arr = new boj[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new boj(Integer.parseInt(bf.readLine()), i); // 인덱스와 원소 값을 배열 arr에 저장
        }
        Arrays.sort(arr);
        int res = -1;
        for (int i=0; i<n; i++) {
            if (res < arr[i].idx - i) { // arr[i].idx => 정렬 전 인덱스, i => 정렬 후의 인덱스
                res = arr[i].idx - i;
            }
        }
        System.out.println(res + 1);
    }
}
class boj implements Comparable<boj> { // 인덱스, 원소 값 저장할 클래스
    int value, idx;

    public boj(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }
    @Override
    public int compareTo(boj o) {
        return this.value - o.value;
    }
}
