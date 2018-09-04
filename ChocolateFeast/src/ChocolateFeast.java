/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
 * Java program from Hackerrank problem.
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ChocolateFeast {

    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) {
        // n is money
        // c is cost
        // m is wrappers
        int chocs = n / c;
        int w = chocs;

        while (w >= m) {
            chocs += w / m;
            w = w / m + (w % m);
        }
        return chocs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String fileName = "output.txt";

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);

            bufferedWriter.write(String.valueOf(result));
            System.out.println(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
