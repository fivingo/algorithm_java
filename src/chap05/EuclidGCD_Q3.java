package chap05;

import java.util.Scanner;

// 유클리드 호제법으로 최대공약수 구하기
public class EuclidGCD_Q3 {

    // 정수 x, y의 최대공약수를 구하여 반환합니다.
    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    static int gcdArray(int[] a, int start, int size) {
        if (size == 1) {
            return a[start];
        } else if (size == 2) {
            return gcd(a[start], a[start + 1]);
        } else {
            return gcd(a[start], gcdArray(a, start + 1, size - 1));
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("몇 개의 정수의 최대 공약수?: ");
        int num = stdIn.nextInt();

        int[] a = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("정수 입력: ");
            a[i] = stdIn.nextInt();
        }

        System.out.println("최대공약수는 " + gcdArray(a, 0, num) + "입니다.");
    }
}
