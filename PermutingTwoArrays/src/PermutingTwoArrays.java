import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class PermutingTwoArrays {

    // Complete the twoArrays function below.
    static String twoArrays(int k, int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int slider = 0;
        boolean okSoFar = true;
        while (slider < a.length && okSoFar) {
            if (a[a.length - slider - 1] + b[slider] < k) {
                okSoFar = false;
            }
            slider++;
        }

        if (okSoFar) {
            System.out.println("YES");
            return "YES";
        } else {
            System.out.println("NO");
            return "NO";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String newFile = "output.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile, true));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            String result = twoArrays(k, A, B);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
