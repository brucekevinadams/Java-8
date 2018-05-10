import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.*;
import java.util.*;

public class TimeFormatter {

	static String timeConversion(String s) {

		DateFormat df = new SimpleDateFormat("hh:mm:ssaa");
		// Desired format: 24 hour format: Change the pattern as per the need
		DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
		Date date = null;
		String output = null;
		try {
			// Converting the input String s to Date
			date = df.parse(s);
			// Changing the format of date and storing it in String
			output = outputformat.format(date);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		return output;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a time in format HH:MM:SSAM/PM (ex:10:15:00PM)");
		String s = sc.nextLine();

		String result = timeConversion(s);
		System.out.println(result);

		// Write the output to a file and append the file
		try {
			String str = System.lineSeparator() + result;
			Files.write(Paths.get("./timeFormatter.txt"), str.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc.close();
	}
}
