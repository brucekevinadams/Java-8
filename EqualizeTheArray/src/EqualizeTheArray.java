/*
*   Author: Bruce Adams
*   email: ezaroth@gmail.com
*   website: austingamestudios.com
*
*   This program is a Java 8 program from a Hackerrank problem
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class EqualizeTheArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) al.add(scan.nextInt());
        HashSet<Integer> hs = new HashSet<>(al);
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer i : hs) res.add(Collections.frequency(al, i));
        System.out.println(n - Collections.max(res, null));
    }
}
