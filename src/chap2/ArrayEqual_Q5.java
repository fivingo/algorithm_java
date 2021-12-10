package chap2;

import java.util.Scanner;

public class ArrayEqual_Q5 {

    // 두 배열 a, b의 모든 요소가 같은가?
    static boolean equals(int[] a, int [] b) {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }

        return true;
    }

    // 배열 b의 모든 요소를 배열 a에 역순으로 복사함
    static void rcopy(int[]a, int[] b) {
        if (a.length == b.length) {
            for (int i = 0; i < b.length; i++) {
                a[i] = b[b.length - i - 1];
            }
        } else {
            System.out.println("배열의 길이가 다릅니다.");
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열 a의 요솟수: ");
        int na = stdIn.nextInt();   // 배열 a의 요솟수

        int[] a = new int[na];      // 요솟수가 na인 배열

        for (int i = 0; i < na; i++) {
            System.out.print("a[" + i + "]: ");
            a[i] = stdIn.nextInt();
        }

        System.out.print("배열 b의 요솟수: ");
        int nb = stdIn.nextInt();   // 배열 b의 요솟수

        int[] b = new int[nb];      // 요솟수가 nb인 배열

        for (int i = 0; i < nb; i++) {
            System.out.print("b[" + i + "]: ");
            b[i] = stdIn.nextInt();
        }

        rcopy(a, b);

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
