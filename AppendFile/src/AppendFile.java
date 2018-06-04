
/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
 Java program to append a string to the
 end of a file.
*/

import java.io.*;
import java.util.Scanner;

public class AppendFile {

	public static void appendStrToFile(String fileName, String str) {
		try {

			// Open given file in append mode.
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
			out.write(str);
			out.close();
		} catch (IOException e) {
			System.out.println("exception occoured" + e);
		}
	}
	
    private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// Let us create a sample file with some text
		String fileName = "output.txt";
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write("Hello World:\n");
			out.close();
		} catch (IOException e) {
			System.out.println("Exception Occurred" + e);
		}

		// Let us append given str to above
		// created file.
        String str = sc.nextLine();
		appendStrToFile(fileName, str);

		// Let us print modified file
		try {
			BufferedReader in = new BufferedReader(new FileReader("output.txt"));

			String mystring;
			while ((mystring = in.readLine()) != null) {
				System.out.println(mystring);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Exception Occurred" + e);
		}
		
	}
}