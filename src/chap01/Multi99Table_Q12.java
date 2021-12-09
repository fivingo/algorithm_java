package chap01;

public class Multi99Table_Q12 {
    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.print("   |");
                    } else {
                        System.out.printf("%3d", j);
                    }
                } else {
                    if (j == 0) {
                        System.out.printf("%2d", i);
                        System.out.print(" |");
                    } else {
                        System.out.printf("%3d", i * j);
                    }
                }
            }

            if (i == 0) {
                System.out.print("\n---+----------------------------");
            }

            System.out.println();
        }
    }
}
