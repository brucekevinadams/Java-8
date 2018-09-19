/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
 * Java program allows a user to pick a file using a dialog box.
 * The program then performs three CRC 32 checksum calculations using
 * the Buffered Stream method, the Random Access File method, and the Mapped
 * File method. Times in ms are included. Usually the Bufferend Input Steam Method
 * is the fastest.
*/

import java.awt.*;
import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;

public class JavaCRC32 {

    public static long checksumInputStream(String filepath) throws IOException {

        InputStream inputStreamn = new FileInputStream(filepath);
        CRC32 crc = new CRC32();
        int cnt;

        while ((cnt = inputStreamn.read()) != -1)
            crc.update(cnt);

        return crc.getValue();
    }

    public static long checksumBufferedInputStream(String filepath) throws IOException {

        InputStream inputStream = new BufferedInputStream(new FileInputStream(filepath));
        CRC32 crc = new CRC32();
        int cnt;

        while ((cnt = inputStream.read()) != -1)
            crc.update(cnt);

        return crc.getValue();
    }

    public static long checksumRandomAccessFile(String filepath) throws IOException {

        RandomAccessFile randAccfile = new RandomAccessFile(filepath, "r");
        long length = randAccfile.length();
        CRC32 crc = new CRC32();

        for (long i = 0; i < length; i++) {
            randAccfile.seek(i);
            int cnt = randAccfile.readByte();
            crc.update(cnt);
        }

        return crc.getValue();
    }

    public static long checksumMappedFile(String filepath) throws IOException {

        FileInputStream inputStream = new FileInputStream(filepath);
        FileChannel fileChannel = inputStream.getChannel();
        int len = (int) fileChannel.size();
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, len);
        CRC32 crc = new CRC32();

        for (int cnt = 0; cnt < len; cnt++) {
            int i = buffer.get(cnt);
            crc.update(i);
        }

        return crc.getValue();
    }

    public static void main(String[] args) throws IOException {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getFile();

        String path = dialog.getDirectory() + dialog.getFile();
        System.out.println("File Path: " + path);
        System.out.println("File: " + file);

        long start_timer = System.currentTimeMillis();
        long crc = checksumInputStream(path);
        long end_timer = System.currentTimeMillis();

        System.out.println("Checksum value: " + Long.toHexString(crc));
        System.out.println((end_timer - start_timer) + " ms");
        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("Buffered Input Stream method:");

        start_timer = System.currentTimeMillis();
        crc = checksumBufferedInputStream(path);
        end_timer = System.currentTimeMillis();
        System.out.println("Checksum value: " + Long.toHexString(crc));
        System.out.println((end_timer - start_timer) + " ms");

        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("Random Access File method:");
        start_timer = System.currentTimeMillis();
        crc = checksumRandomAccessFile(path);
        end_timer = System.currentTimeMillis();
        System.out.println("Checksum value: " + Long.toHexString(crc));
        System.out.println((end_timer - start_timer) + " ms");


        System.out.println("///////////////////////////////////////////////////////////");
        System.out.println("Mapped File method:");
        start_timer = System.currentTimeMillis();
        crc = checksumMappedFile(path);
        end_timer = System.currentTimeMillis();
        System.out.println("Checksum value: " + Long.toHexString(crc));
        System.out.println((end_timer - start_timer) + " ms");
    }
}
