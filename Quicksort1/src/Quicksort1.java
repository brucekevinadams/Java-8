/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program
 * From a Hackerrank problem
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Quicksort1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();//filling elements into array
        }

        @SuppressWarnings("deprecation") ArrayList left = new ArrayList<>();
        @SuppressWarnings("deprecation") ArrayList equal = new ArrayList<>();
        @SuppressWarnings("deprecation") ArrayList right = new ArrayList<>();

        int p = arr[0];

        for (int i = 0; i < n; i++) {
            if (p == arr[i]) {
                equal.add(arr[i]);
            } else if (p > arr[i]) {
                left.add(arr[i]);
            } else {
                right.add(arr[i]);
            }
        }
        int count1 = 0;
        while (left.size() > count1) {
            System.out.print(left.get(count1) + " ");
            count1++;
        }

        int count2 = 0;
        while (equal.size() > count2) {
            System.out.print(equal.get(count2) + " ");
            count2++;
        }

        int count3 = 0;
        while (right.size() > count3) {
            System.out.print(right.get(count3) + " ");
            count3++;
        }

    }
}
