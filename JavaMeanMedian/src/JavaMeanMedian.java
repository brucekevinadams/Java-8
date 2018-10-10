/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * Java 8 program that asks the user to enter the size of an array of integers
 * The user then enters the numbers into the array and the program computes
 * the mean and median of the array of integers printing them to console and
 * into an output file.
 * Hackerrank problem
 *
*/

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class JavaMeanMedian {
    // Function for calculating mean 
    public static double findMean(int a[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += a[i];

        return (double) sum / (double) n;
    }

    // Function for calculating median 
    public static double findMedian(int a[], int n) {
        // First we sort the array 
        Arrays.sort(a);

        // check for even case 
        if (n % 2 != 0)
            return (double) a[n / 2];

        return (double) (a[(n - 1) / 2] + a[n / 2]) / 2.0;
    }

    // Driver program 
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the size of an array to be entered: ");
        int n = scan.nextInt();
        System.out.println("Please enter " + n + " integers.");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        int s = a.length;
        System.out.println("Mean = " + findMean(a, n));
        System.out.println("Median = " + findMedian(a, n));
    }
} 
