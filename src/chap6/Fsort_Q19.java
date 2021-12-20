package chap6;

import java.util.Scanner;

// 도수 정렬
class Fsort_Q19 {

    // 도수 정렬 (min 이상 max 이하의 값)
    static void fSort(int[] a, int n, int min, int max) {
        int[] f = new int[max - min + 2];           // 누적 도수
        int[] b = new int[n];                       // 작업용 목적 배열

        for (int i = 0; i < n; i++) {               // 1단계: 도수분포표 만들기
            f[a[i] - min]++;
        }

        for (int i = 1; i <= max - min + 1; i++) {  // 2단계: 누적도수분포표 만들기
            f[i] += f[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {          // 3단계: 목적 배열 만들기
            b[--f[a[i] - min]] = a[i];
        }

        for (int i = 0; i < n; i++) {               // 4단계: 배열 복사하기
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

        int min = x[10];

        for (int i = 1; i < nx; i++) {
            if (x[i] < min) {
                min = x[i];
            }
        }

        fSort(x, nx, min, max);                  // 배열 x를 도수 정렬

        System.out.println("오름차순으로 정렬합니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
