import java.io.*;
import java.util.*;

public class LeapYear {
	
/*
    Divisible by 400.
    Divisible by 4 and not divisible by 100 .

Given a year, y, find the date of the 256th day of that year according to
the official Russian calendar during that year. Then print it in the
 format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is y.
*/
	// Complete the solve function below.
	static String solve(int year) {

		if (year == 1918)
			return "26.09.1918";
		if (isLeap(year))
			return "12.09." + Integer.toString(year);
		else
			return "13.09." + Integer.toString(year);

	}

	static boolean isLeap(int year) {

		if (year % 4 != 0)
			return false;
		if (year > 1918 && year % 100 == 0 && year % 400 != 0)
			return false;
		return true;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("leapYear.txt"));

		int year = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = solve(year);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
