package chap01;

import java.util.Scanner;

// 1, 2, ..., n의 합을 구합니다.
public class SumOf_Q9 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 수 사이의 합을 구합니다.");
        System.out.print("첫번째 값: ");
        int n1 = stdIn.nextInt();
        System.out.print("두번째 값: ");
        int n2 = stdIn.nextInt();

        int sum = 0;

        if (n1 == n2) {
            System.out.println("다른 두 수를 입력하세요.");
        } else if (n1 < n2) {
            for (int i = n1; i <= n2; i++) {
                sum += i;
            }

            System.out.println(n1 + "과 " + n2 + "사이의 합은 " + sum + "입니다.");
        } else {
            for (int i = n2; i <= n1; i++) {
                sum += i;
            }

            System.out.println(n2 + "과 " + n1 + "사이의 합은 " + sum + "입니다.");
        }
    }
}
