package chap06;

import java.util.Arrays;
import java.util.Scanner;

// Arrays.sort 메서드를 사용하여 정렬 (퀵 정렬)
class ArraysSort {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];     // 배열의 크기는 num

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        Arrays.sort(x);             // 배열 x를 정렬

        System.out.println("오름차순으로 정렬합니다.");
        for (int i = 0; i < num; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
