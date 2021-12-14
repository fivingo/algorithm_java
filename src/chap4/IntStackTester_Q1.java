package chap4;

import java.util.Scanner;

// int형 스택의 사용 예
public class IntStackTester_Q1 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);  // 최대 64개를 푸시할 수 있는 스택

        while (true) {
            System.out.println("\n현재 데이터 수: " + s.size() + " / " + s.capacity());
            System.out.println("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 검색 (6) 비우기");
            System.out.print("(7) 비었는지 확인 (8) 가득찬지 확인 (0) 종료: ");

            int menu = stdIn.nextInt();

            if (menu == 0) {
                break;
            }

            int x;

            switch (menu) {
                case 1:         // 푸시
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();

                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:         // 팝
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:         // 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:         // 덤프
                    s.dump();
                    break;

                case 5:         // 검색
                    System.out.print("검색할 데이터: ");
                    int num = stdIn.nextInt();
                    int index = s.indexOf(num);

                    System.out.println(num + "은(는) " + (index >= 0 ? "s[" + index + "] 입니다." : "없습니다."));
                    break;

                case 6:         // 비우기
                    s.clear();
                    System.out.println("스택을 비웠습니다.");
                    break;

                case 7:         // 비었는지 확인
                    boolean empty = s.isEmpty();
                    System.out.println(empty ? "스택이 비었습니다." : "스택이 비어 있지 않습니다.");
                    break;

                case 8:         // 가득찬지 확인
                    boolean full = s.isFull();
                    System.out.println(full ? "스택이 가득 찼습니다." : "스택이 가득 차지 않았습니다.");
                    break;
            }
        }
    }
}
