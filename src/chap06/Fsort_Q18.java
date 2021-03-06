package chap06;

import java.util.Scanner;

// 도수 정렬
class Fsort_Q18 {

    // 도수 정렬 (0 이상 max 이하의 값을 입력)
    static void fSort(int[] a, int n, int max) {
        int[] f = new int[max + 1];         // 누적 도수
        int[] b = new int[n];               // 작업용 목적 배열

        System.out.println("1단계: 도수분포표 만들기");    // 1단계
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= max; j++) {
                System.out.printf("%3d", f[j]);
            }
            System.out.println();

            f[a[i]]++;
        }

        for (int j = 0; j <= max; j++) {
            System.out.printf("%3d", f[j]);
        }
        System.out.println();

        System.out.println("2단계: 누적도수분포표 만들기");  // 2단계
        for (int i = 1; i <= max; i++) {
            for (int j = 0; j <= max; j++) {
                System.out.printf("%3d", f[j]);
            }
            System.out.println();

            f[i] += f[i - 1];
        }

        for (int j = 0; j <= max; j++) {
            System.out.printf("%3d", f[j]);
        }
        System.out.println();

        System.out.println("3단계: 목적 배열 만들기");       // 3단계
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", b[j]);
            }
            System.out.println();

            b[--f[a[i]]] = a[i];
        }

        for (int j = 0; j < n; j++) {
            System.out.printf("%3d", b[j]);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {                   // 4단계
            a[i] = b[i];
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요소수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < 0);
        }

        int max = x[0];

        for (int i = 1; i < nx; i++) {
            if (x[i] > max) {
                max = x[i];
            }
        }

        fSort(x, nx, max);                  // 배열 x를 도수 정렬

        System.out.println("오름차순으로 정렬합니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
