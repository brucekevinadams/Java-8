/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * Hackerrank problem
*/

import java.util.Scanner;

public class SherlockAndTheBeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            {
                int n = in.nextInt();
                StringBuilder strb = new StringBuilder();
                for (int i = n; i >= 0; i--)

                {
                    if (i % 3 == 0 && (n - i) % 5 == 0) {
                        int j = 0;
                        for (j = 0; j < i; j++)
                            strb.append("5");
                        for (int k = j; k < n; k++)
                            strb.append("3");
                        break;

                    }
                }
                if (strb.length() == 0)
                    System.out.println("-1");
                else
                    System.out.println(strb);
            }
        }
    }
}
