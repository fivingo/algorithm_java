package chap07;

// int형 집합
public class IntSet {
    private int max;                    // 집합의 최대 개수
    private int num;                    // 집합의 요소 개수
    private int[] set;                  // 집합 본체

    // 생성자
    public IntSet(int capacity) {
        num = 0;
        max = capacity;

        try {
            set = new int[max];         // 집합 배열 생성
        } catch (OutOfMemoryError e) {  // 배열 생성 실패
            max = 0;
        }
    }

    // 집합의 최대 개수
    public int capacity() {
        return  max;
    }

    // 집합의 요소 개수
    public int size() {
        return num;
    }

    // 집합에서 n을 검색 (index 반환)
    public int indexOf(int n) {
        for (int i = 0; i < num; i++) {
            if (set[i] == n) {
                return i;               // 검색 성공
            }
        }

        return -1;                      // 검색 실패
    }

    // 집합에 n이 있는지 확인
    public boolean contains(int n) {
        return (indexOf(n) != -1) ? true : false;
    }

    // 집합에 n을 추가
    public boolean add(int n) {
        if (num >= max || contains(n) == true) {        // 가득 찼거나 이미 n이 존재
            return false;
        } else {
            set[num++] = n;                             // 가장 마지막 자리에 추가
        }

        return true;
    }

    // 집합에서 n을 삭제
    public boolean remove(int n) {
        int idx;                                        // n이 저장된 요소의 인덱스

        if (num <= 0 || (idx = indexOf(n)) == -1) {     // 비어 있거나 n이 존재하지 않음
            return false;
        } else {
            set[idx] = set[--num];                      // 마지막 요소를 삭제한 곳으로 옮김
        }

        return true;
    }

    // 집합 s에 복사
    public void copyTo(IntSet s) {
        int n = (s.max < num) ? s.max : num;            // 복사할 요소 개수

        for (int i = 0; i < n; i++) {
            s.set[i] = set[i];
        }

        s.num = n;
    }

    // 집합 s를 복사
    public void copyFrom(IntSet s) {
        int n = (max < s.num) ? max : s.num;            // 복사할 요소 개수

        for (int i = 0; i < n; i++) {
            set[i] = s.set[i];
        }

        num = n;
    }

    // 집합 s와 같은지 확인
    public boolean equalTo(IntSet s) {
        if (num != s.num) {                             // 요소 개수가 같지 않으면
            return false;                               // 집합도 같지 않다.
        }

        for (int i = 0; i < num; i++) {
            int j = 0;

            for (; j < s.num; j++) {
                if (set[i] == s.set[j]) {
                    break;
                }
            }

            if (j == s.num) {                           // set[i]는 s에 포함되지 않음
                return false;
            }
        }

        return true;
    }

    // 집합 s1과 s2의 합집합을 복사
    public void unionOf(IntSet s1, IntSet s2) {
        copyFrom(s1);                                   // 집합 s1을 복사

        for (int i = 0; i < s2.num; i++) {              // 집합 s2의 요소를 추가
            add(s2.set[i]);
        }
    }

    // "{a, b, c}" 형식의 문자열로 표현을 바꿈
    public String toString() {
        StringBuffer temp = new StringBuffer("{ ");

        for (int i = 0; i < num; i++) {
            temp.append(set[i] + " ");
        }

        temp.append("}");

        return temp.toString();
    }

    // 공집합인지 확인
    public boolean isEmpty() {
        return num == 0;
    }

    // 집합이 가득 찼는지 확인
    public boolean isFull() {
        return num >= max;
    }

    // 집합을 초기화 (모든 요소를 삭제)
    public void clear() {
        num = 0;
    }

    // 집합 s와 합집합
    public boolean canCombine(IntSet s) {
        boolean done = false;

        for (int i = 0; i < num; i++) {
            if (add(set[i]) == true) {
                done = true;
            }
        }

        return done;
    }

    // 집합 s와 교집합
    public boolean canIntersection(IntSet s) {
        boolean done = false;

        for (int i = 0; i < num; i++) {
            if (s.contains(set[i]) == false) {
                remove(set[i]);
                done = true;
            }
        }

        return done;
    }

    // 집합 s와 차집합
    public boolean canDifference(IntSet s) {
        boolean done = false;

        for (int i = 0; i < num; i++) {
            if (s.contains(set[i]) == true) {
                remove(set[i]);
                done = true;
            }
        }

        return done;
    }

    // 집합 s의 부분집합인지 확인
    public boolean isSubsetOf(IntSet s) {
        for (int i = 0; i < num; i++) {
            int j = 0;

            for (; j < s.num; j++) {
                if (set[i] == s.set[j]) {
                    break;
                }
            }

            if (j == s.num) {       // set[i]는 s에 포함되지 않음
                return false;
            }
        }

        return true;
    }

    // 집합 s의 진부분집합인지 확인
    public boolean isProperSubsetOf(IntSet s) {
        if (num >= s.num) {         // 요소 갯수가 s의 요소 개수이상이면
            return false;           // s의 진부분집합이 아님
        }

        return s.isSubsetOf(s);
    }

    // 집합 s1과 s2의 교집합을 복사
    public void intersectionOf(IntSet s1, IntSet s2) {
        clear();

        for (int i = 0; i < s1.num; i++) {
            if (s2.contains(s1.set[i])) {
                add(s1.set[i]);
            }
        }
    }

    // 집합 s1과 s2의 차집합을 복사
    public void differenceOf(IntSet s1, IntSet s2) {
        clear();

        for (int i = 0; i < s1.num; i++) {
            if (!s2.contains(s1.set[i])) {
                add(s1.set[i]);
            }
        }
    }
}
