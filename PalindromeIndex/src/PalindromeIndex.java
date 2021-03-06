/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * Hackerrank problem
 * Given a string of lowercase letters in the range ascii[a-z], 
 * determine a character that can be removed to make the string a palindrome.
 * There may be more than one solution, but any will do. For example, if your
 * string is "bcbc", you can either remove 'b' at index 0 or 'c' at index 3.
 * If the word is already a palindrome or there is no solution, return -1. 
 * Otherwise, return the index of a character to remove. 
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PalindromeIndex {

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {

        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                if (isPalindrome(s, i))
                    return i;
                else if (isPalindrome(s, j))
                    return j;
        return -1;

    }

    static boolean isPalindrome(String s, int index) {
        for (int i = index + 1, j = s.length() - 1 - index; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String output = "output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output,true));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            System.out.println(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
