package chap05;

import java.util.Scanner;

// 하노이의 탑
public class Hanoi_Q7 {

    // no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int no, int x, int y) {
        int[] xStack = new int[100];
        int[] yStack = new int[100];
        int[] rStack = new int[100];            // 재귀 처리 여부 스택
        int pointer = 0;
        int rState = 0;                         // 재귀 처리 여부

        while (true) {
            if (rState == 0 && no > 1) {
                xStack[pointer] = x;            // x의 값을 푸시
                yStack[pointer] = y;            // y의 값을 푸시
                rStack[pointer] = rState;       // rState의 값을 푸시

                pointer++;
                no = no - 1;
                y = 6 - x - y;

                continue;
            }

            System.out.println(no + "을 " + x + "기둥에서 " + y + "기둥으로 옮김");

            if (rState == 1 && no > 1) {
                xStack[pointer] = x;            // x의 값을 푸시
                yStack[pointer] = y;            // x의 값을 푸시
                rStack[pointer] = rState;       // x의 값을 푸시

                pointer++;
                no = no - 1;
                y = 6 - x - y;

                if (++rState == 2) {
                    rState = 0;
                }

                continue;
            }

            do {
                if (pointer-- == 0) {           // 스택이 비었을때
                    return;
                }

                x = xStack[pointer];            // 저장하고 있는 값을 팝
                y = yStack[pointer];            // 저장하고 있는 값을 팝
                rState = rStack[pointer];       // 저장하고 있는 값을 팝

                no++;
            } while (rState == 2);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수: ");
        int n = stdIn.nextInt();

        move(n, 1, 3);      // 1번 기둥의 n개 원반을 3번 기둥으로 옮김
    }
}
