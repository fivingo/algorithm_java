package chap01;

import java.util.Scanner;

public class SumForPos_Q11 {
    public static void main(String[] args) {
        int n;
        int temp;
        int digits = 0;

        Scanner stdIn = new Scanner(System.in);

        System.out.print("양의 정수 입력: ");
        n = stdIn.nextInt();
        temp = n;

        do {
            temp = temp / 10;
            digits++;
        } while (temp >= 1);

        System.out.println(n + "는 " + digits + "자리입니다.");
    }
}
