import java.io.*;
import java.util.*;

public class Array2DReturnAsFunction {

    // Complete the array2D function below.
    static int array2D(int[][] a) {
	      
    int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                if (i > 1 && j > 1)
                {
                    int sum =
                        a[i][j]
                        + a[i][j-1]
                        + a[i][j-2]
                        + a[i-1][j-1]
                        + a[i-2][j]
                        + a[i-2][j-1]
                        + a[i-2][j-2];
                    if (sum > maxSum) {maxSum = sum;}
                }
            }
        }
    System.out.println(maxSum);
    return maxSum;
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("2DArrayReturnedAsFunction.txt"));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = array2D(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}