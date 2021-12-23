package chap03;

import java.util.Arrays;

// Arrays.binarySearch로 이진 검색
public class BinarySearchTester_Q6 {
    public static void main(String[] args) {
        int num = 7;
        int[] x = {15, 27, 39, 77, 92, 108, 121};
        int ky = 40;

//        Scanner stdIn = new Scanner(System.in);
//
//        System.out.print("요소수: ");
//        int num = stdIn.nextInt();
//        int[] x = new int[num];             // 요소수가 num인 배열
//
//        System.out.println("오름차순으로 입력하세요.");
//
//        System.out.print("x[0]: ");         // 배열의 첫 요소를 먼저 입력합니다.
//        x[0] = stdIn.nextInt();
//
//        for (int i = 1; i < num; i++) {
//            do {
//                System.out.print("x[" + i + "]: ");
//                x[i] = stdIn.nextInt();
//            } while (x[i] < x[i -1]);       // 바로 앞의 요소보다 작으면 다시 입력합니다.
//        }
//
//        System.out.print("검색할 값: ");     // 키 값을 입력 받음
//        int ky = stdIn.nextInt();

        int idx = Arrays.binarySearch(x, ky);   // 배열 x에서 키 값이 ky인 요소를 검색

        if (idx < 0) {
            idx  = -idx - 1;

            System.out.println(ky + "은(는) 값의 요소가 없습니다. 삽입포인트는 " + idx + "입니다.");
        } else {
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
        }
    }
}
