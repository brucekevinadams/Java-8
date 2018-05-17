/*
 * The user inputs how large an integer array will be, then inputs the integers into the array arr[]
 * We calculate the respective first quartile (), second quartile ()
 * and third quartile () and print them to the console.
 */

import java.util.*;

public class Quartiles {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of integers to be inserted in Array: ");
		int arrCount = Integer.parseInt(scanner.nextLine().trim());

		int[] arr = new int[arrCount];

		System.out.println("Enter " + arrCount + " integers on one line: ");
		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < arrCount; i++) {
			int arrItem = Integer.parseInt(arrItems[i].trim());
			arr[i] = arrItem;
		}

		// Must sort in ascending order to properly determine median of array
		Arrays.sort(arr);

		System.out.println("Q1 median: " + median(arr, 0, arrCount / 2 - 1));
		System.out.println("Q2 median: " + median(arr, 0, arrCount - 1));
		if (arrCount % 2 == 0) {// Array is filled with even number of numbers
			System.out.println("Q3 median: " + median(arr, arrCount/2, arrCount-1));
		} else {
			System.out.println("Q3 median: " + median(arr, arrCount/2+1, arrCount-1));
		}
		scanner.close();
	}


	public static int median(int[] arr, int start, int end) {
		int length = end - start + 1;
		int median = 0;
		if (length % 2 != 0) {
			median = arr[start + length / 2];
		} else {
			median = (arr[start + length /2 - 1] + arr[ start + length /2]) / 2;
		}
		return median;		
	}
	

}
