package chap01;

import java.util.Scanner;

public class Multi99Table_Q14 {
    public static void main(String[] args) {
        System.out.println("사각형을 출력합니다.");
        System.out.print("단 수: ");

        int n;

        Scanner stdIn = new Scanner(System.in);
        n = stdIn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
