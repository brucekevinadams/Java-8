/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program that adds up the number of words in a string with each word
 * starting with a Capital letter. Not counting the first word, which starts
 * as a lower-case word
 * From a Hackerrank problem
 */

import java.util.Scanner;

public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int terms = 1;
        for (int i = 0; i < s.length(); i++) {
            String letter = Character.toString(s.charAt(i));
            if (letter == letter.toUpperCase()) {
                terms++;
            }
        }
        System.out.println(terms);
    }
}
