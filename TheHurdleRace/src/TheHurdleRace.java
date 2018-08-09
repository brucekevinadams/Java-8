import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TheHurdleRace {

    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
        return Math.max((IntStream.of(height).summaryStatistics().getMax() - k), 0);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String fileName = "output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] height = new int[n];

        String[] heightItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int heightItem = Integer.parseInt(heightItems[i]);
            height[i] = heightItem;
        }

        int result = hurdleRace(k, height);

        bufferedWriter.write(String.valueOf(result));
        System.out.println(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
