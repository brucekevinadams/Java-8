import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */

        int x = Math.min(p / 2, n / 2 - p / 2);
        return x;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String fileName = "output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        System.out.println(String.valueOf(result));
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
