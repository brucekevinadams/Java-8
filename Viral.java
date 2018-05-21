import java.io.*;
import java.util.*;

public class Viral {

	// Complete the viralAdvertising function below.
	static int viralAdvertising(int n) {

		int like = 0, share = 0, sum = 0;
		for (int i = 1; i <= n; i++) {
			if (i == 1)// for the first day
			{
				like = 5 / 2;
			} else // for the rest of the days.. which includes sharing
			{
				share = like * 3;
				like = share / 2;
			}
			sum += like;
		}

		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("viral.txt"));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int result = viralAdvertising(n);
		System.out.println(result);
		
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
