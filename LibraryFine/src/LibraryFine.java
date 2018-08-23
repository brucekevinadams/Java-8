import java.util.Scanner;

public class LibraryFine {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        int fine;
        if (y2 == y1 || y1 < y2) {
            if (m2 == m1 || m1 < m2) {
                if (d2 == d1 || d1 < d2) {
                    fine = 0;
                } else
                    fine = (d1 - d2) * 15;
            } else
                fine = (m1 - m2) * 500;
        } else
            fine = 10000;
        System.out.println(fine);
    }
}
