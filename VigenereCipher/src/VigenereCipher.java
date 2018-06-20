import java.util.Scanner;

/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
Java implementation of Vigenere cipher. The Vigenère cipher is a method of encrypting 
alphabetic text by using a series of interwoven Caesar ciphers based on the letters
of a keyword. It is a form of polyalphabetic substitution
*/

public class VigenereCipher {

	public static String encrypt(String text, final String key) {

		String res = "";
		text = text.toUpperCase();

		for (int i = 0, j = 0; i < text.length(); i++) {

			char c = text.charAt(i);

			if (c < 'A' || c > 'Z')

				continue;

			res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');

			j = ++j % key.length();

		}

		return res;
	}

	public static String decrypt(String text, final String key) {

		String res = "";

		text = text.toUpperCase();

		for (int i = 0, j = 0; i < text.length(); i++) {

			char c = text.charAt(i);

			if (c < 'A' || c > 'Z')

				continue;

			res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');

			j = ++j % key.length();

		}

		return res;
	}

	public static void main(String[] args) {

		String key = "VIGENERECIPHER";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string to encrypt: ");
		String message = scanner.nextLine();

		String encryptedMsg = encrypt(message, key);
		System.out.println("String: " + message);
		System.out.println("Encrypted message: " + encryptedMsg);
		System.out.println("Decrypted message: " + decrypt(encryptedMsg, key));
		scanner.close();
	}

}