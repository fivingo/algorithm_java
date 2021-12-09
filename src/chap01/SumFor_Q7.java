package chap01;

import java.util.Scanner;

// 1, 2, ..., n의 합을 구합니다.
public class SumFor_Q7 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값: ");
        int n = stdIn.nextInt();

        int sum = 0;    // 합

        for (int i = 1; i <= n; i++) {
            sum += i;   // sum에 i를 더합니다.
            System.out.print(i);

            if (i < n) {
                System.out.print(" + ");
            } else if (i == n) {
                System.out.print(" = " + sum);
            }
        }
    }
}
