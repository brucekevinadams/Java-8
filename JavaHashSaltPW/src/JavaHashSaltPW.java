
/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
 * Java program that takes a user password, and hashes it
 * using Salt to further randomize the hash. It then stores
 * the salted hash in a text file named output.txt.
 * 
 * This program is to demonstrate how hasing a password works.
*/

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class JavaHashSaltPW {

    public static void appendStrToFile(String fileName, String str) {
        try {

            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
            out.write(str);
            out.newLine();
            out.close();
        } catch (IOException e) {
            System.out.println("Exception Occurred" + e);
        }
    }


    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String fileName = "hash_output.txt";
        Scanner str = new Scanner(System.in);
        System.out.println("What password do you want to hash?");
        String originalPassword = str.nextLine();

        String generatedSecuredPasswordHash = generateStorngPasswordHash(originalPassword);
        System.out.println(generatedSecuredPasswordHash);
        appendStrToFile(fileName, generatedSecuredPasswordHash);
        str.close();
    }

    private static String generateStorngPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

}
