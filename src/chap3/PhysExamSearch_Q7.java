package chap3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 신체검사 데이터 배열에서 이진 검색하기
public class PhysExamSearch_Q7 {

    // 신체검사 데이터를 정의합니다.
    static class PhyscData {
        private String name;            // 이름
        private int height;             // 키
        private double vision;          // 시력

        // 생성자
        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        // 문자열을 반환하는 메서드 (정보 확인용)
        public String toString() {
            return name + " " + height + " " + vision;
        }

        // 내림차순으로 정렬하기 위한 comparator
        public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhyscData> {

            @Override
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.vision < d2.vision) ? 1 : (d1.vision > d2.vision) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        PhyscData[] x = {                           // 시력의 내림차순으로 정렬되어 있습니다.
                new PhyscData("이수민", 175, 2.0),
                new PhyscData("홍준기", 171, 1.5),
                new PhyscData("이호연", 174, 1.2),
                new PhyscData("김한경", 169, 0.8),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("이나령", 162, 0.3),
        };

        System.out.print("시력이 몇 인 사람을 찾고 있나요?: ");
        double vision = stdIn.nextDouble();         // 키 값 입력
        int idx = Arrays.binarySearch(
                x,                                  // 배열 x에서
                new PhyscData("", 0, vision),       // 시력이 vision 요소를
                PhyscData.VISION_ORDER              // VISION_ORDER 의해 검색
        );

        if (idx < 0) {
            System.out.println("요소가 없습니다.");
        } else {
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터: " + x[idx]);
        }
    }
}
