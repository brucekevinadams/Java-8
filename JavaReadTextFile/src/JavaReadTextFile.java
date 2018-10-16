/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program that will ask the user to select a text file
 * The program will then output the contents of the text file to console
 */

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class JavaReadTextFile {
    public static void main(String[] args) throws Exception {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        System.out.println("Select file to open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String filename = dialog.getFile();

        String path = dialog.getDirectory() + dialog.getFile();
        System.out.println("File Path: " + path);
        System.out.println("File: " + filename + "\n");

        BufferedReader input = new BufferedReader(new FileReader(path));
        String st;
        System.out.println("< CONTENTS OF FILE >");
        while ((st = input.readLine()) != null)
            System.out.println(st);

        input.close();
    }
}
