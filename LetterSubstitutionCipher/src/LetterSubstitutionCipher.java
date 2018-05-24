
/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
This program reads a file (dictionary.lst) which has a single "encrypted" word per line, parses it to a string and
then decrypts the file contents. A map is used to store the "from" and "to" key/value pairs 
*/

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LetterSubstitutionCipher {

	private static Map<Character, Character> map;

	@SuppressWarnings({ "resource", "boxing" })
	public static void main(String args[]) throws IOException {

		// Initialize all variables
		String line = "";
		String encryptedText = "";
		String space = " ";

		// Open up the input file
		Scanner sc = new Scanner(new File("dictionary.lst"));
		while (sc.hasNext()) {
			line = sc.nextLine();
			encryptedText += line + space;
		}

		// Show the encrypted text from the file
		System.out.println("Encrypted text from file: " + encryptedText);

		// Created key / value strings for map
		String from = "abcdefghijklmnopqrstuvwxyz";
		String to = "wztbeacktohspylugdri3hfynm";

		// Use a map to have key=alphabet and value=substituted letter
		map = new HashMap<Character, Character>();
		for (int i = 0; i < from.length(); ++i)
			map.put(from.charAt(i), to.charAt(i));

		// The stringbuilder will decrypt the encryptedText string to
		// the correctly formatted decrypt and store in
		StringBuilder decrypt = new StringBuilder();

		for (Character c : encryptedText.toCharArray()) {
			decrypt.append(map.getOrDefault(c, c));
		}

		// Print to console the decrypted decrypt
		System.out.println("Decrypted text: " + decrypt.toString());

	}
}
