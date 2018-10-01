/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * From a Hackerrank problem
 */

import java.util.Scanner;

class PlayWithWords {
    static int larger(int a, int b) {
        return a > b ? a : b;
    }

    static int solve(char[] s) {
        final int n = s.length;
        int[] l = new int[n], r = new int[n];
        l[0] = 1;
        r[n - 1] = 1;
        int[] prev = new int[n], lps = new int[n];
        for (int i = 0; i < n; ++i) lps[i] = 1;
        for (int j = 1; j < n; ++j) {
            for (int i = 0; i < n - j; ++i) {
                prev[i] = lps[i];
                if (s[i] == s[j + i]) lps[i] = 2 + prev[i + 1];
                else lps[i] = larger(lps[i], lps[i + 1]);
            }
            l[j] = lps[0];
            r[n - j - 1] = lps[n - j - 1];
        }
        int best = 0;
        for (int i = 0; i < n - 1; ++i) {
            int score = l[i] * r[i + 1];
            if (score > best) best = score;
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solve(sc.next().toCharArray()));
        sc.close();
    }
}
