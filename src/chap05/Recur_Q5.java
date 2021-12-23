package chap05;

import java.util.Scanner;

public class Recur_Q5 {

    // 비재귀적 구현
    static void recur3(int n) {
        int[] numStack = new int[100];
        int[] recursiveStateStack = new int[100];
        int pointer = -1;
        int recursiveState = 0;         // 재귀 처리 여부

        while (true) {
            if (n > 0) {
                pointer++;
                numStack[pointer] = n;
                recursiveStateStack[pointer] = recursiveState;

                if (recursiveState == 0) {
                    n = n - 1;
                } else if (recursiveState == 1) {
                    n = n - 2;
                    recursiveState = 0;
                }

                continue;
            }

            do {
                n = numStack[pointer];
                recursiveState = recursiveStateStack[pointer--] + 1;

                if (recursiveState == 2) {
                    System.out.println(n);

                    if (pointer < 0) {
                        return;
                    }
                }
            } while (recursiveState == 2);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int x = stdIn.nextInt();

        recur3(x);
    }
}
