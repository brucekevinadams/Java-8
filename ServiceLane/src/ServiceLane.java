/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
 * Java program from a Hackerrank problem.
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ServiceLane {

    // Complete the serviceLane function below.
    static int[] serviceLane(int n, int[] w, int[][] cases) {

        int[] result = new int[cases.length];
        int c = 0;
        for (int i = 0; i < cases.length; i++) {
            int temp = w[cases[i][0]];
            for (int j = cases[i][0]; j <= cases[i][1]; j++) {
                if (temp >= w[j]) {
                    temp = w[j];
                }
            }
            System.out.println();
            result[c] = temp;
            c++;
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String fileName = "output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));

        String[] nt = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nt[0]);

        int t = Integer.parseInt(nt[1]);

        int[] width = new int[n];

        String[] widthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }

        int[][] cases = new int[t][2];

        for (int i = 0; i < t; i++) {
            String[] casesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }
        }

        int[] result = serviceLane(n, width, cases);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            System.out.println(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
