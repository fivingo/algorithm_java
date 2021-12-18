package chap6;

import java.util.Scanner;

// 버블 정령 (버전3)
public class BubbleSort3_Q4 {

    // a[idx1]의 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬 (버전3)
    static void bubbleSort(int[] a, int n) {
        int compareCount = 0;                   // 비교 횟수
        int exchangeCount = 0;                  // 교환 횟수
        int i = 0;
        int k = 0;                              // a[k]보다 앞쪽은 정렬을 마친 상태

        while (k < n - 1) {
            int last = n - 1;                   // 마지막으로 요소를 교환한 위치

            System.out.println("\n패스" + i++);

            for (int j = n - 1; j > k; j--) {   // 패스
                for (int m = 0; m < n - 1; m++) {
                    System.out.print(" " + a[m] + " " + ((m != j - 1) ? " " : (a[j - 1] > a[j]) ? "+" : "-"));
                }

                System.out.println(" " + a[n - 1]);

                compareCount++;

                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                    exchangeCount++;
                }
            }

            k = last;
        }

        System.out.println("비교를 " + compareCount + "회 했습니다.");
        System.out.println("교환를 " + exchangeCount + "회 했습니다.");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬 (버전3)");
        System.out.print("요소수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);              // 배열 x를 버블 정렬 합니다.

        System.out.println("오름차순으로 정렬합니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
