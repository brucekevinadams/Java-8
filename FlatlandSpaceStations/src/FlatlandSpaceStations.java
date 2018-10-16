/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * Hackerrank problem
 */

import java.util.Arrays;
import java.util.Scanner;

public class FlatlandSpaceStations {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for (int i = 0; i < m; i++) {
            c[i] = in.nextInt();
        }
        int a[] = new int[n];
        Arrays.fill(a, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int x = c[i];
            for (int j = 0; j < n; j++) {
                if (j == x)
                    a[j] = 0;
                else if (a[j] > Math.abs(j - x))
                    a[j] = Math.abs(j - x);
            }
        }
        Arrays.sort(a);
        System.out.println(a[n - 1]);
        in.close();
    }
}