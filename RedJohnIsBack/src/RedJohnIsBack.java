/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * From a Hackerrank problem
 */

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class RedJohnIsBack {

    public static final HashMap<Integer, String> factStore = new HashMap<>();


    static BigInteger fact(int N) {
        if (factStore.containsKey(N))
            return new BigInteger(factStore.get(N));

        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= N; i++)
            f = f.multiply(BigInteger.valueOf(i));

        factStore.put(N, String.valueOf(f));

        return f;

    }


    public static int sieve(int n) {
        int count = 0;
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++)
            if (prime[p] == true)
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;

        for (int i = 2; i <= n; i++)
            if (prime[i] == true)
                count++;

        return count;
    }

    public static int countWays(int n) {
        int size = n;
        int sum = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, size);
        map.put(4, 0);
        while (map.get(1) > 3) {
            map.put(1, map.get(1) - 4);
            map.put(4, map.get(4) + 1);
            if (map.get(1) != 0 && map.get(4) != 0) {
                BigInteger b1 = fact(map.get(1));
                BigInteger b2 = fact(map.get(4));
                BigInteger b = fact(map.get(1) + map.get(4));
                BigInteger res = b.divide(b1.multiply(b2));

                sum += res.intValue();
            } else
                sum++;
        }

        return sieve(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int l = 0; l < t; l++) {
            int n = sc.nextInt();
            int res = countWays(n);
            System.out.println(res);
        }
    }
}
