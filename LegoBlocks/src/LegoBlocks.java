/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * From a Hackerrank problem
 */

import java.util.Scanner;

class LegoBlocks {
    static final int mod = 1000000007;
    static int[] f;

    static int mult(int x, int y) {
        long z = x;
        z *= y;
        return (int) (z % mod);
    }

    static int pow(int x, int n) {
        int r = 1;
        while (n != 1) {
            if ((n & 1) == 1) r = mult(r, x);
            x = mult(x, x);
            n >>= 1;
        }
        return mult(x, r);
    }

    static int add(int x, int y) {
        return (x + y) % mod;
    }

    static void computeF(int highM) {
        if (highM < 4) highM = 4;
        f = new int[highM + 1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        f[3] = 4;
        for (int i = 4; i <= highM; ++i) {
            int x = 0;
            for (int j = 1; j <= 4; ++j) {
                x = add(x, f[i - j]);
            }
            f[i] = x;
        }
    }

    static long solve(int n, int m) {
        int[] g = new int[m + 1], h = new int[m + 1];
        g[1] = 1;
        h[1] = 0;
        for (int i = 2; i <= m; ++i) {
            int x = 0;
            for (int j = 1; j < i; ++j) {
                x = add(x, mult(g[j], g[i - j]));
                x = add(x, mult(g[j], h[i - j]));
            }
            h[i] = x;
            g[i] = add(pow(f[i], n), mod - h[i]);
        }
        return g[m];
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] an = new int[t], am = new int[t];
        for (int i = 0; i < t; ++i) {
            an[i] = sc.nextInt();
            am[i] = sc.nextInt();
        }
        sc.close();
        int highM = 0;
        for (int m : am) {
            if (m > highM) highM = m;
        }
        computeF(highM);
        for (int i = 0; i < t; ++i) {
            System.out.println(solve(an[i], am[i]));
        }
    }

    public static void main(String[] args) {
        input();
    }
}
