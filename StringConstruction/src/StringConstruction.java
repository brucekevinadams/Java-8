/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * Hackerrank problem that prints the minimum cost of copying a string. 
 * It does this by using .distinct() and .count() to count each letter
 * only once, even if the letter is repeated multiple times.
 */
 

import java.util.Scanner;

public class StringConstruction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int a = 0; a < n; a++) {
            String s = in.next();
            System.out.println(s.chars().distinct().count());
        }
    }

}
