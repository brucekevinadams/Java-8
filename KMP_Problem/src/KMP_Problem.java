/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * From a Hackerrank problem
 */

import java.util.Scanner;

public class KMP_Problem {
    public static void main(String[] args) {
        char ch = 'a', ch1;
        String s1 = "";
        int ar[] = new int[26];
        int min = 99999999, loc = 0;
        int loc2 = 0;
        Scanner in = new Scanner(System.in);
        int k = 0;
        for (int i = 0; i < 26; i++) {
            ar[i] = in.nextInt();
            if (ar[i] < min && ar[i] != 0) {
                min = ar[i];
                loc = i;
            }
            if (ar[i] != 0) {
                k++;
                if (k == 2) {
                    loc2 = i;
                }
            }
        }
        ch1 = (char) (97 + loc);
        ar[loc] = ar[loc] - 1;
        s1 = s1 + Character.toString(ch1);
        if (ar[loc] < ar[loc2]) {
            ch1 = (char) (97 + loc);
            char ch2 = (char) (97 + loc2);
            int len1 = ar[loc];
            if (ch1 < ch2) {
                s1 = s1 + new String(new char[len1]).replace("\0", Character.toString(ch1) + Character.toString(ch2));
                ar[loc2] = ar[loc2] - len1;
                ar[loc] = ar[loc] - len1;
            }
        }

        for (int i = 0; i < 26; i++) {
            String s = new String(new char[ar[i]]).replace("\0", Character.toString(ch));
            s1 = s1 + s;
            ++ch;
        }
        System.out.println(s1);
    }
}
