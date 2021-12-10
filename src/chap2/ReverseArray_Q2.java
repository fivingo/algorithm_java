package chap2;

import java.util.Scanner;

// 배열 요소에 값을 읽어 들여 역순으로 정렬합니다.
public class ReverseArray_Q2 {

    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿈
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 배열 a의 요소를 역순으로 정렬
    static void reverse(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < a.length / 2; i++) {
            System.out.println("a[" + i + "]과(와) a[" + (a.length - i - 1) + "]를 교환합니다.");

            swap(a, i, a.length - i - 1);

            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();  // 요솟수

        int[] x = new int[num];     // 요솟수가 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        reverse(x); // 배열 a의 요소를 역순으로 정렬

        System.out.println("역순 정렬을 마쳤습니다.");
    }
}
