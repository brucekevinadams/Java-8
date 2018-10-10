/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program 
 * Hackerrank problem
 *
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TheLoveLetterMystery {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        int count = 0;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            int start = s.charAt(i);
            int end = s.charAt(j);

            int diff = Math.abs(start - end);

            count = count + diff;
            i++;
            j--;

        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String output = "output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output,true));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);
            System.out.println(result);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
