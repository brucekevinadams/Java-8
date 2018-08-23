/*
*   Author: Bruce Adams
*   email: ezaroth@gmail.com
*   website: austingamestudios.com
*
*   This program is a Java 8 program that uses AES to encrypt a user entered text
*   and then decrypts the text.
*   Java 8 has finally added Base64 capabilities to the standard API, via the
 *  java.util.Base64 utility class
*
 */

import java.util.Base64;
import java.util.Scanner;


public class AESEncryption2 {

    public static String encrypt(String originalInput) {

        try {
            String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
            return encodedString;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String encodedString) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            String decodedString = new String(decodedBytes);

            return new String(decodedString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text to encrypt: ");

        String original = input.nextLine();

        String encryptedString = encrypt(original);
        System.out.println("Encrypted String - " + encryptedString);
        String decryptedString = decrypt(encryptedString);
        System.out.println("After decryption - " + decryptedString);
    }

}