/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * Hackerrank problem
 */
 

import java.util.Scanner;

public class A_Chessboard_Game {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            if ((x % 4 == 1 || x % 4 == 2) && (y % 4 == 1 || y % 4 == 2)) {
                System.out.println("Second");
            } else {
                System.out.println("First");
            }
        }
    }
}
