package chap3;

import java.util.Scanner;

// 선형 검색 (보초법)
public class SeqSearchSen_Q1 {

    // 요소수가 n인 배열 a에서 key와 같은 요소를 보초법으로 선형 검색합니다.
    static int seqSearchSen(int[] a, int n, int key) {
        a[n] = key;             // 보초를 추가

        int i;

        for (i = 0; i < n; i++) {
            if (a[i] == key)
                break;;
        }

        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1];             // 요소수 num + 1

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값: ");         // 키 값을 입력
        int ky = stdIn.nextInt();

        int idx = seqSearchSen(x, num, ky);     // 배열 x에서 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
    }
}
