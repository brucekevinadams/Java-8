/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * Hackerrank problem that prints an integer representing the
 * minimum number of deletions needed to make the strings anagrams. 
 */

import java.util.Scanner;

public class MakingAnagrams {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int d = 0;
        for (int i = 0, k; i < s1.length(); i++)
            if ((k = s2.indexOf(s1.charAt(i))) != -1) {
                s2 = s2.substring(0, k) + s2.substring(k + 1);
                d++;
            }
        System.out.println(s1.length() + s2.length() - d);

    }
}
