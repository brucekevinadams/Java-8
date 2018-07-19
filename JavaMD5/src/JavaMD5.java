/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
 Java program to create an MD5 hash of a user entered string.
 This is from a Hackerrank problem.
 The program will also create a text file and then append the user 
 inputted string and the MD5 hash output to the  end of the file.
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Scanner;

public class JavaMD5 {

    public static void appendStrToFile(String fileName, String str) {
        try {
            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
            out.write(str);
            out.newLine();
            out.close();
        } catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
    }

    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        System.out.println("Input string to convert to MD5 hash:");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        md.update(str.getBytes());

        // Let us create a sample file with some text
        String fileName = "MD5output.txt";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(str);
            out.newLine();
            out.close();
        } catch (IOException e) {
            System.out.println("Exception Occurred" + e);
        }

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        appendStrToFile(fileName, sb.toString());
        System.out.println("MD5 Digest(in hex format):: " + sb.toString());


    }
}
