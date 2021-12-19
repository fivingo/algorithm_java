package chap6;

import java.util.Scanner;

// 셸 정렬 (버전1)
public class ShellSort_Q9 {

    // 셸 정렬
    static int shellSort(int[] a, int n) {
        int count = 0;      // 옮긴 횟수

        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];

                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    count++;
                }

                a[j + h] = tmp;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셸 정렬 (버전1)");
        System.out.print("요소수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        int count = shellSort(x, nx);              // 배열 x를 셸 정렬

        System.out.println("오름순으로 정렬합니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
        System.out.println("옮긴 횟수는 " + count + "회");
    }
}
