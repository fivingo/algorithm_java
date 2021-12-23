package chap02;

public class PhysicalExample_Q11 {
    static class YMD {
        int y;
        int m;
        int d;

        YMD(int y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        // 각 달의 일수
        int[][] mdays = {
                { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
                { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 윤년
        };

        // 서기 year년은 윤년인가? (윤년：1／평년：0)
        int isLeap(int year) {
            return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
        }

        // n일 뒤의 날짜를 반환
        void YMDafter(int n) {
            d += n;

            while (d > mdays[isLeap(y)][m - 1]) {
                d -= mdays[isLeap(y)][m - 1];
                m++;

                if (m > 12) {
                    m = 1;
                    y++;
                }
            }
        }

        // n일 앞의 날짜를 반환
        void YMDbefore(int n) {
            d -= n;

            while (d < 1) {
                m--;

                if (m < 1) {
                    m = 12;
                    y--;
                }
                d += mdays[isLeap(y)][m - 1];
            }
        }
    }


    public static void main(String[] args) {
        int year = 2021;
        int month = 12;
        int day = 11;
        int changedDays = 200;

        YMD ymdAfter = new YMD(year, month, day);
        ymdAfter.YMDafter(changedDays);
        System.out.println(changedDays + "일 후는 " + ymdAfter.y + "년 " + ymdAfter.m + "월 " + ymdAfter.d + "일");

        YMD ymdBefore = new YMD(year, month, day);
        ymdBefore.YMDbefore(changedDays);
        System.out.println(changedDays + "일 전은 " + ymdBefore.y + "년 " + ymdBefore.m + "월 " + ymdBefore.d + "일");
    }
}
