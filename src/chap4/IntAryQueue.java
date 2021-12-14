package chap4;

// int형 큐
public class IntAryQueue {
    private int max;            // 스택 용량
    private int num;            // 스택 포인터
    private int[] que;          // 스택 본체

    // 실행 시 예외: 큐가 비어있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    // 실행 시 예외: 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    // 생성자
    public IntAryQueue(int capacity) {
        num = 0;
        max = capacity;

        try {
            que = new int[max];         // 큐 본체용 배열을 생성
        } catch (OutOfMemoryError e) {  // 생성할 수 없음
            max = 0;
        }
    }

    // 큐에 데이터를 인큐
    public int enque(int x) throws OverflowIntQueueException {
        if (num >= max) {               // 큐가 가득 참
            throw new OverflowIntQueueException();
        }
        que[num++] = x;

        return x;
    }

    // 큐에서 데이터를 디큐
    public int deque() throws EmptyIntQueueException {
        if (num <= 0) {                 // 큐가 비어 있음
            throw new EmptyIntQueueException();
        }

        int x = que[0];

        for (int i = 0; i < num - 1; i++) {
            que[i] = que[i + 1];
        }

        num--;

        return x;
    }

    // 큐에서 데이터를 피크
    public int peek() throws EmptyIntQueueException {
        if (num <= 0) {                 // 큐가 비어있음
            throw new EmptyIntQueueException();
        }

        return que[num - 1];
    }

    // 큐에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i--) {    // 정상 쪽에서 선형 검색
            if (que[i] == x) {
                return i;                       // 검색 성공
            }
        }

        return -1;                              // 검색 실패
    }

    // 큐를 비움
    public void clear() {
        num = 0;
    }

    // 큐의 용량을 반환
    public int capacity() {
        return max;
    }

    // 큐에 쌓여있는 데이터 수를 반환
    public int size() {
        return num;
    }

    // 큐가 비어 있는가?
    public boolean isEmpty() {
        return num <= 0;
    }

    // 큐가 가득 찼는가?
    public boolean isFull() {
        return num >= max;
    }

    // 스택 안의 모든 데이터를 머리 -> 꼬리 순서로 출력
    public void dump() {
        if (num <= 0) {
            System.out.println("큐가 비어 있습니다.");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[i] + " ");
            }
            System.out.println();
        }
    }
}
