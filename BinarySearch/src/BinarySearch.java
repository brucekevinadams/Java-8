/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
Function to have user input an array of n numbers. The array is sorted, and the user is asked to input a 
number to look for. Then a function will determine whether the number is located in the array and what index
it is at. If the number is not in the array, the program will output "N is not present in the list."
*/

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	@SuppressWarnings("boxing")
	public static void main(String args[]) {

		System.out.print("Enter array size: ");
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		System.out.print("Enter " + n + " numbers into the array.");

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		Arrays.sort(arr);
		
		System.out.print("What number do you want to search for?");
		int num = scan.nextInt();
		System.out.printf("Binary Search for number %d in integer array %s %n", num, Arrays.toString(arr));
		binarySearch(arr, num);

		scan.close();

	}

	/**
	 * Perform a binary Search in Sorted Array in Java
	 *
	 * @param input
	 * @param number
	 * @return location of element in array
	 */
	@SuppressWarnings("boxing")
	public static void binarySearch(int[] input, int number) {
		int first = 0;
		int last = input.length - 1;
		int middle = (first + last) / 2;

		while (first <= last) {
			if (input[middle] < number) {
				first = middle + 1;
			} else if (input[middle] == number) {
				System.out.printf(number + " found at location %d %n", middle);
				break;
			} else {
				last = middle - 1;
			}
	//		middle = (first + last) / 2;
			middle = first + ((last - first) / 2);
		}
		if (first > last) {
			System.out.println(number + " is not present in the list.\n");
		}
	}
}
