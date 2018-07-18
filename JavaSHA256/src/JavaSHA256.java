/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
This program shows how SHA256 works and is from a Hackerrank java problem. It will
take any string, integers, or characters and convert them using the Java
JavaSHA256() method that is found in the MessageDigest class. It converts the binary hash into a 64 digit 0x hex ouput to
shorten the 256 bits of binary to more readable form. This is because one Hex digit
represents 4 binary bits (this is called a "Nibble").

Sample Input
HelloWorld

Sample Output
872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4
*/


import java.security.MessageDigest;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

/**
 * Demonstrates how to generate SHA256 hash in Java
 */
public class JavaSHA256 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
    //    System.out.print("Please enter data for which SHA256 is required:");
        String data = sn.nextLine();

        JavaSHA256 sj = new JavaSHA256();
        String hash = sj.getSHA256Hash(data);
        // Hexadecimal output in upper case is changed to lower case
        System.out.println(hash.toLowerCase());
    }

    /**
     * Returns a hexadecimal encoded SHA-256 hash for the input String.
     * @param data
     * @return
     */
    private String getSHA256Hash(String data) {
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            return bytesToHex(hash); // make it printable
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * Use javax.xml.bind.DatatypeConverter class in JDK to convert byte array
     * to a hexadecimal string. Note that this generates hexadecimal in upper case.
     * @param hash
     * @return
     */
    private String  bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }
}