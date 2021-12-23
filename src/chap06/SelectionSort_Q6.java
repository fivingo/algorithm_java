package chap06;

import java.util.Scanner;

public class SelectionSort_Q6 {

    // a[idx1]의 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 단순 선택 정렬
    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;            // 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 기록

            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            for (int k = 0; k < n; k++) {
                System.out.print((k == i) ? "  * " : (k == min) ? " + " : "   ");
            }

            System.out.println();

            for (int k = 0; k < n; k++) {
                System.out.print("  " + a[k]);
            }

            System.out.println();
            System.out.println();

            swap(a, i, min);        // 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 선택 정렬");
        System.out.print("요소수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x, nx);              // 배열 x를 단순 선택 정렬 합니다.
    }
}
