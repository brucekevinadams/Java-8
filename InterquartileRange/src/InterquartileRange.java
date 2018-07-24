/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
 Java program to calculate the interquartile range.

 This is from the Hackerrank problem Day 1: Interquartile Range
 Input Format

The first line contains an integer, n, denoting the number of elements in arrays X and F.
The second line contains n space-separated integers describing the respective elements of array X.
The third line contains n space-separated integers describing the respective elements of array F.

Sample Input

6
6 12 8 10 20 16
5 4 3 2 1 5

Sample Output

9.0
*/

import java.util.Scanner;
import java.util.Arrays;

public class InterquartileRange {

    public static void main(String[] args) {
        /* Read and save input */
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int [] element = new int[size];
        int [] frequency = new int[size];
        try {
            for (int i = 0; i < size; i++) {
                element[i] = scan.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int numElements = 0;
        try {
            for (int i = 0; i < size; i++) {
                frequency[i] = scan.nextInt();
                numElements += frequency[i];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /* Create and sort our data set */
        int [] data = new int[numElements];
        int dataIndex = 0;
        try {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < frequency[i]; j++) {
                    data[dataIndex] = element[i];
                    dataIndex++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Arrays.sort(data);
        
        /* Works with both even and odd length arrays */
        double q1 = findMedian(data, 0, data.length / 2 - 1);
        double q3 = findMedian(data, (data.length + 1) / 2, data.length - 1);

        System.out.println(q3 - q1);
    }

    /* Treats elements from "start" to "end" as an array and calculates its median */
    private static double findMedian(int [] array, int start, int end) {
        if ((end - start) % 2 == 0) { // odd number of elements
            return (array[(end + start) / 2]);
        } else { // even number of elements
            int value1 = array[(end + start) / 2];
            int value2 = array[(end + start) / 2 + 1];
            return (value1 + value2) / 2.0;
        }
    }
}
