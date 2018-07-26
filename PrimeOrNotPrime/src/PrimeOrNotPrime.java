import java.util.*;

public class PrimeOrNotPrime {

	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		// Ask user for number of integers
		System.out.println("How many numbers for your array?");
		int N = scan.nextInt();

		// Create array
		int arr[] = new int[N];

		System.out.println("Enter " + N + " numbers into your array");
		// Loop to insert all scanned user integers into array
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		for (int i = 0; i < N; i++) {
			if (!isPrime(arr[i]))
				System.out.println("Number " + arr[i] + " is Not Prime");
			else
				System.out.println("Number " + arr[i] + " is Prime");
		}
	}
}