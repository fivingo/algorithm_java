package chap03;

import java.util.Scanner;

// 선형 검색
public class SeqSearch_Q3 {

    // 요소수가 n인 배열 a에서 key와 같은 요소를 선형 검색합니다.
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;                          // 요소 개수

        for (int i = 0; i < n; i++) {
            if (key == a[i]) {
                idx[count++] = i;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];                 // 요소수가 num인 배열
        int[] y = new int[num];                 // 일치하는 요소수를 담을 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값: ");         // 키 값을 입력
        int ky = stdIn.nextInt();

        int result = 0;

        result = searchIdx(x, num, ky, y);
        System.out.println("일치한 요소수: " + (result > 0 ? result : 0) + "개");
    }
}
