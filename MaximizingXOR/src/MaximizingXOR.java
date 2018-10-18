/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * Given two integers, L and R, find the maximal value of xor L and R 
 * The program runs between the numbers, starting at L and ending at R
 * For example, if L is 2 and R is 5, the program XOR's 2 and 3, 2 and 4 and
 * 2 and 5, to find the largest XOR result, which is then print out to console
 */

import java.util.Scanner;

public class MaximizingXOR {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int L = scan.nextInt();
        int R = scan.nextInt();
        scan.close();

        int xored = L ^ R;
        int significantBit = 31 - Integer.numberOfLeadingZeros(xored);
        int result = (1 << (significantBit + 1)) - 1;

        System.out.println(result);
    }
}

