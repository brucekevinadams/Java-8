/*
*   Author: Bruce Adams
*   email: ezaroth@gmail.com
*   website: austingamestudios.com
*
*   This program is a Java 8 program that is from a Hackerrank problem
*   It is about rotating an array.
*
*/

import java.util.Scanner;

public class LarrysArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            bubbleSort(a, n);
            System.out.println(a[n - 2] < a[n - 1] ? "YES" : "NO");
        }
    }

    public static void bubbleSort(int[] array, int n) {
        for (int i = 0; i < n - 2; i++) {
            for (int j = n - 2 - 1; j >= i; j--) {
                while (array[j] > array[j + 1] || array[j] > array[j + 2]) {
                    rotate(array, j);
                }
            }
        }
    }

    public static void rotate(int[] arr, int a) {
        int temp = arr[a];
        arr[a] = arr[a + 1];
        arr[a + 1] = arr[a + 2];
        arr[a + 2] = temp;
    }
}
