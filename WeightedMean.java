package weighted;

import java.util.Scanner;

public class WeightedMean {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of integers to be inserted in Array: ");
		int arrCount = Integer.parseInt(scanner.nextLine().trim());

		// Array 1
		int[] arr = new int[arrCount];
		System.out.println("Enter " + arrCount + " integers on one line for Array 1: ");
		String[] arrItems = scanner.nextLine().split(" ");

		for (int arrItr = 0; arrItr < arrCount; arrItr++) {
			int arrItem = Integer.parseInt(arrItems[arrItr].trim());
			arr[arrItr] = arrItem;
		}

		// Array 2
		int[] arr2 = new int[arrCount];
		System.out.println("Enter " + arrCount + " integers on one line for Array 2: ");
		String[] arrItems2 = scanner.nextLine().split(" ");

		for (int arrItr = 0; arrItr < arrCount; arrItr++) {
			int arrItem = Integer.parseInt(arrItems2[arrItr].trim());
			arr2[arrItr] = arrItem;
		}

		System.out.printf("Weighted Mean of 2 Arrays: %,.1f%n", weightedMean(arr, arr2, arrCount));
		scanner.close();
	}

	// Function to calculate weighted mean.
	static float weightedMean(int[] arr, int[] arr2, int n) {
		int sum = 0;
		int numWeight = 0;

		for (int i = 0; i < n; i++) {
			numWeight = numWeight + arr[i] * arr2[i];
			sum = sum + arr2[i];
		}

		return (float) (numWeight) / sum;
	}

}
