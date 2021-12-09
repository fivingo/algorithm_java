package chap01;

import java.util.Scanner;

public class SumForPos_Q10 {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;

        Scanner stdIn = new Scanner(System.in);

        System.out.print("a의 값: ");
        a = stdIn.nextInt();

        do {
            System.out.print("b의 값: ");
            b = stdIn.nextInt();

            if (b <= a) {
                System.out.println("a보다 큰 값을 입력하세요.");
            }
        } while (b <= a);

        System.out.println("b - a는 " + (b - a) + "입니다.");
    }
}
