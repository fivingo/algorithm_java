package chap06;

import java.util.Scanner;

// 힙 정렬
class heapSort_Q17 {

    // a[idx1]의 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 2의 n제곱을 구합니다.
    static int pow2(int n) {
        int power = 1;

        while (n-- > 0) {
            power *= 2;
        }

        return power;
    }

    // n개의 공백 출력
    static void displaySpace(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    // 힙을 출력
    static void displayHeap(int[] a, int n) {
        int i = n;
        int height = 1;             // 트리의 높이

        while ((i >>= 1) > 0) {     // 비트 연산자
            height++;
        }

        i = 0;
        int w = 1;

        Loop: {
            for (int level = 0; level < height; level++) {
                displaySpace(pow2(height - level) - 3);

                for (int j = 0; j < w; j++) {
                    System.out.printf("%02d", a[i++]);

                    if (i >= n) {
                        break Loop;
                    }

                    if (j < w - 1) {
                        displaySpace(pow2(height - level + 1) - 2);
                    }
                }

                System.out.println();

                displaySpace(pow2(height - level) - 4);

                for (int j = 0; j < w; j++) {
                    if (2 * j + i < n) {
                        System.out.print(" / ");
                    }

                    if (2 * j + i + 1 < n) {
                        System.out.print(" \\ ");
                    }

                    if (j < w - 1) {
                        displaySpace(pow2(height - level + 1) - 4);
                    }
                }

                System.out.println();
                w *= 2;
            }
        }

        System.out.println();
        System.out.println();
    }

    // a[left] ~ a[right]를 힙으로 만듭니다.
    static void downHeap(int[] a, int left, int right) {
        int temp = a[left];         // 루트
        int child;                  // 큰 값을 가진 노드
        int parent;                 // 부모

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;                            // 왼쪽 자식
            int cr = cl + 1;                                    // 오른쪽 자식
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;   // 큰 값을 가진 노드를 자식에 대입

            if (temp >= a[child]) {
                break;
            }

            a[parent] = a[child];
        }

        a[parent] = temp;
    }

    // 힙 정렬
    static void heapSort(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {        // a[i] ~ a[n - 1]를 힙으로 만들기
            displayHeap(a, n);
            downHeap(a, i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);                              // 가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
            displayHeap(a, n);
            downHeap(a, 0, i - 1);                      // a[0] ~ a[i - 1]를 힙으로 만듭니다.
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.print("요소수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        heapSort(x, nx);                                // 배열 x를 힙 정렬

        System.out.println("오름차순으로 정렬합니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
