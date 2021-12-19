package chap6;

import java.util.Scanner;

// 셸 정렬 (버전2, h의 값은 ..., 40, 13, 4, 1)
public class ShellSort2 {

    // 셸 정렬
    static void shellSort(int[] a, int n) {
        int h;

        for (h = 1; h < n / 9; h = h * 3 + 1) {     // h의 초기값 구함
            ;
        }

        for (; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];

                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                }

                a[j + h] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셸 정렬 (버전2)");
        System.out.print("요소수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        shellSort(x, nx);              // 배열 x를 셸 정렬

        System.out.println("오름순으로 정렬합니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
