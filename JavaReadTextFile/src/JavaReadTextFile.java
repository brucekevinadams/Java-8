// Java Program to illustrate reading from 
// FileReader using FileReader 

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class JavaReadTextFile {
    public static void main(String[] args) throws Exception {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String filename = dialog.getFile();

        String path = dialog.getDirectory() + dialog.getFile();
        System.out.println("File Path: " + path);
        System.out.println("File: " + filename);

        BufferedReader input = new BufferedReader(new FileReader(filename));
        String st;
        while ((st = input.readLine()) != null)
            System.out.println(st);

        input.close();
    }
}
