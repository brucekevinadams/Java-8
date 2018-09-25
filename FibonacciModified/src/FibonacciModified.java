/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * From a Hackerrank problem
 */

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

    public static void main(String[] args) {
        int i, n;
        BigInteger a, b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextBigInteger();
        b = sc.nextBigInteger();
        n = sc.nextInt();
        BigInteger[] val = new BigInteger[n];
        val[0] = a;
        val[1] = b;
        for (i = 2; i < n; i++) {
            val[i] = (val[i - 1].pow(2)).add(val[i - 2]);
        }
        System.out.println(val[i - 1]);
    }
}
