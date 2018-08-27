/*
*   Author: Bruce Adams
*   email: ezaroth@gmail.com
*   website: austingamestudios.com
*
*   This program is a Java 8 program from a Hackkerrank problem to print to console
*   the "Kaprekar numbers" for a given number that is input from the user.
*  if the representation of its square in that base can be split into two parts that add
*  up to the original number, with the proviso that the part formed from the low-order digits
*  of the square must be non-zero—although it is allowed to include leading zeroes.
*  For instance, 45 is a Kaprekar number, because 452 = 2025 and 20 + 25 = 45.
*
 */

import java.util.Scanner;

public class ModifiedKaprekarNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int p = scan.nextInt();
        int q = scan.nextInt();
        scan.close();

        boolean foundKaprekar = false;
        for (int num = p; num <= q; num++) {
            if (isKaprekar(num)) {
                foundKaprekar = true;
            }
        }
        if (!foundKaprekar) {
            System.out.println("INVALID RANGE");
        }
    }

    private static boolean isKaprekar(int num) {
        long squared = (long) num * num;
        String str = String.valueOf(squared);
        String left = str.substring(0, str.length() / 2);
        String right = str.substring(str.length() / 2);
        int numL = (left.isEmpty()) ? 0 : Integer.parseInt(left);
        int numR = (right.isEmpty()) ? 0 : Integer.parseInt(right);
        if (numL + numR == num) {
            System.out.print(num + " ");
            return true;
        } else {
            return false;
        }
    }
}
