/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * Hackerrank problem
 * Updated version of the Tower Breakers problem, here you must find if a 
 * value is prime or not before proceeding
 */

import java.util.Scanner;

public class TowerBreakersRevisited {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
        boolean isPrime[] = new boolean[10000000 + 1];
        for (
                int k = 2;
                k <= 10000000; k++)
            isPrime[k] = true;
        for (
                int factor = 2;
                factor * factor <= 10000000; factor++)

        {
            if (isPrime[factor]) {
                for (int j = factor; j * factor <= 10000000; j++)
                    isPrime[j * factor] = false;
            }
        }
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int val = 0;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                int count = 0;
                if (isPrime[a[i]])
                    count = 1;
                else {
                    for (int k = 2; k <= a[i]; k++)
                        if (isPrime[k]) {
                            if (a[i] % k == 0) {
                                a[i] = a[i] / k;
                                k = k - 1;
                                count++;
                            }
                        }
                }
                val ^= count;
            }
            if (val != 0) System.out.println("1");
            else System.out.println("2");
        }
    }
}
