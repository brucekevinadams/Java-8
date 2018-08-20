import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.abs;

public class BeautifulDaysAtTheMovies {


    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int num, count = 0, gn;
        int quo, newNum = 0;
        for (int y = i; y <= j; y++) {
            num = y;
            newNum = 0;
            //For reversing no
            while (num != 0) {
                quo = num % 10;
                newNum = 10 * newNum + quo;
                num = num / 10;
            }
            gn = abs(y - newNum);
            if (gn % k == 0) {
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String fileName = "output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,true));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);
        int j = Integer.parseInt(ijk[1]);
        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
