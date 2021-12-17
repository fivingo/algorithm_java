package chap6;

import java.util.Scanner;

// 버블 정령 (버전 1)
public class BubbleSort_Q2 {

    // a[idx1]의 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬
    static void bubbleSort(int[] a, int n) {
        int compareCount = 0;           // 비교 횟수
        int exchangeCount = 0;          // 교환 횟수

        for (int i = 0; i < n - 1; i++) {
            System.out.println("\n패스" + (i + 1));

            for (int j = n - 1; j > i; j--) {
                for (int k = 0; k < n - 1; k++) {
                    System.out.print(" " + a[k] + " " + ((k != j - 1) ? " " : (a[j - 1] > a[j]) ? "+" : "-"));
                }

                System.out.println(" " + a[n - 1]);

                compareCount++;

                if (a[j - 1] > a[j]) {
                    exchangeCount++;
                    swap(a, j - 1, j);
                }
            }

            for (int k = 0; k < n; k++) {
                if (k == 0) {
                    System.out.print(" " + a[k]);
                } else {
                    System.out.print("   " + a[k]);
                }
            }
            System.out.println();
        }

        System.out.println("비교를 " + compareCount + "회 했습니다.");
        System.out.println("교환를 " + exchangeCount + "회 했습니다.");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

//        System.out.println("버블 정렬 (버전 1)");
//        System.out.print("요소수: ");
//        int nx = stdIn.nextInt();
//        int[] x = new int[nx];
//
//        for (int i = 0; i < nx; i++) {
//            System.out.print("x[" + i + "]: ");
//            x[i] = stdIn.nextInt();
//        }
        int nx = 7;
        int[] x = {6, 4, 3, 7, 1, 9, 8};

        bubbleSort(x, nx);              // 배열 x를 버블 정렬 합니다.
    }
}
