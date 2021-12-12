package chap3;

import java.util.Scanner;

// 이진 검색
public class BinSearch_Q4 {

    // 요소수가 n인 배열 a에서 key와 같은 요소를 이진 검색합니다.
    static int binSearch(int[] a, int n, int key) {
        int pl = 0;                             // 검색 범위의 첫 인덱스
        int pr = n - 1;                         // 검색 범위의 끝 인덱스

        System.out.print("  |");
        for (int i = 0; i < a.length; i++) {    // 인덱스 표시
            System.out.print(" " + i);
        }
        System.out.println("\n--+--------------------");

        do {
            int pc = (pl + pr) / 2;                 // 중앙 요소의 인덱스

            if (pl != pc && pc != pr) {             // pl, pc, pr이 같지 않으면
                System.out.print("  | ");

                for (int i = 0; i < pl; i++) {
                    System.out.print("  ");         // 시작 전 공백 넣기
                }

                System.out.print("<-");             // 검색 시작 인덱스 표시

                for (int i = pl + 1; i <= pr; i++) {
                    if (i == pc) {
                        System.out.print("+");      // 중앙 요소 인덱스 표시
                    } else if (i == pr) {
                        System.out.println("->");   // 검색 끝 인덱스 표시
                    } else {
                        System.out.print("  ");     // 범위 공백 넣기
                    }
                }

                System.out.print(pc + " | ");

                for (int i = 0; i < a.length; i++) {// 요소 표시
                    System.out.print(a[i] + " ");
                }

                System.out.println();
            }

            if (a[pc] == key) {
                return pc;              // 검색 성공!
            } else if (a[pc] < key) {
                pl = pc + 1;            // 검색 범위를 뒤쪽 절반으로 좁힘
            } else {
                pr = pc - 1;            // 검색 범위를 앞쪽 절반으로 좁힘
            }
        } while (pl <= pr);

        return -1;                      // 검색 실패!
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];         // 요소수가 num인 배열

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]: ");     // 첫 요소 입력
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);      // 바로 앞의 요소보다 작으면 다시 입력
        }

        System.out.print("검색할 값: ");     // 키 값을 입력
        int ky = stdIn.nextInt();

        int idx = binSearch(x, num, ky);    // 배열 x에서 키 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
    }
}
