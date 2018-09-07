/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
 * Java program from a Hackerrank problem.
*/

import java.util.Scanner;

public class LisasWorkbook {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int chp = sc.nextInt();
        int prob = sc.nextInt();
        int sp = 0;
        int noOfPages = 0;
        for (int i = 0; i < chp; i++) {
            int chpProb = sc.nextInt();
            int pgNo = noOfPages + 1;
            for (int j = 1; j <= chpProb; j++) {
                if (j == pgNo)
                    sp++;
                if (j % prob == 0 && j < chpProb) {
                    pgNo++;
                }
            }
            noOfPages = pgNo;
        }
        System.out.println(sp);
    }
}
