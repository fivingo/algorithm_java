package chap6;

import java.util.Scanner;

// 단순 삽입 정렬 (보초법: 배열의 첫 번째 요소는 비어있음)
public class InsertionSort_Q7 {

    // 단순 삽입 정렬
    static void insertionSort(int[] a, int n) {
        for (int i = 2; i < n; i++) {
            int j = i;
            int tmp = a[0] = a[i];

            for (; a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }

            if (j > 0) {
                a[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요소수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx + 1];              // 1개 추가로 생성

        for (int i = 1; i <= nx; i++) {         // x[1]부터 입력
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx + 1);               // 배열 x를 단순 삽입 정렬 합니다.

        System.out.println("오름차순으로 정렬합니다.");
        for (int i = 1; i <= nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
