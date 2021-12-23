package chap06;

import java.util.Scanner;

public class BubbleSort3_Q5 {

    // a[idx1]의 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 칵테일 정렬 (양방향 버블 정렬)
    static void cocktailSort(int[] a, int n) {
        int left = 0;
        int right = n - 1;
        int last = right;

        while (left < right) {
            for (int j = right; j > left; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
            }

            left = last;

            for (int j = left; j < right; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    last = j;
                }
            }

            right = last;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("칵테일 정렬 (양방향 버블 정렬)");
        System.out.print("요소수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        cocktailSort(x, nx);              // 배열 x를 칵테일 정렬 합니다.

        System.out.println("오름차순으로 정렬합니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
