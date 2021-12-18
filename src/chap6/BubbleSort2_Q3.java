package chap6;

import java.util.Scanner;

// 버블 정령 (버전2)
public class BubbleSort2_Q3 {

    // a[idx1]의 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬 (버전2)
    static void bubbleSort(int[] a, int n) {
        int compareCount = 0;                   // 비교 횟수
        int exchangeCount = 0;                  // 교환 횟수

        for (int i = 0; i < n - 1; i++) {
            System.out.println("\n패스" + (i + 1));

            int exchg = 0;                      // 패스의 교환 횟수를 기록합니다.

            for (int j = n - 1; j > i; j--) {   // 패스
                for (int k = 0; k < n - 1; k++) {
                    System.out.print(" " + a[k] + " " + ((k != j - 1) ? " " : (a[j - 1] > a[j]) ? "+" : "-"));
                }

                System.out.println(" " + a[n - 1]);

                compareCount++;

                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    exchangeCount++;
                    exchg++;
                }
            }

            for (int j = 0; j < n; n++) {
                if (j == 0) {
                    System.out.print(" " + a[j]);
                } else {
                    System.out.print("   " + a[j]);
                }
            }
            System.out.println();

            if (exchg == 0) {                   // 교환이 이루이지 않으면 종료
                break;
            }
        }

        System.out.println("비교를 " + compareCount + "회 했습니다.");
        System.out.println("교환를 " + exchangeCount + "회 했습니다.");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬 (버전2)");
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
