import java.util.*;

public class MeanMedianMode {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of integers to be inserted in Array: ");
		int arrCount = Integer.parseInt(scanner.nextLine().trim());

		double[] arr = new double[arrCount];
		System.out.println("Enter " + arrCount + " integers on one line: ");
		String[] arrItems = scanner.nextLine().split(" ");

		for (int arrItr = 0; arrItr < arrCount; arrItr++) {
			double arrItem = Double.parseDouble(arrItems[arrItr].trim());
			arr[arrItr] = arrItem;
		}
		Arrays.sort(arr);
		System.out.println("Mean: " + mean(arr));
		System.out.println("Median: " + median(arr));
		System.out.println("Mode: " + mode(arr));
		scanner.close();
	}

	public static double mean(double[] m) {
		double sum = 0;
		for (int i = 0; i < m.length; i++) {
			sum += m[i];
		}
		return sum / m.length;
	}

	public static double mode(double a[]) {
		double maxValue = 0;
		int maxCount = 0;

		for (int i = 0; i < a.length; ++i) {
			int count = 0;
			for (int j = 0; j < a.length; ++j) {
				if (a[j] == a[i])
					++count;
			}
			if (count > maxCount) {
				maxCount = count;
				maxValue = a[i];
			}
		}

		return maxValue;
	}

	public static double median(double[] m) {
		int middle = m.length / 2;
		if (m.length % 2 == 1) {
			return m[middle];
		} else {
			return (m[middle - 1] + m[middle]) / 2.0;
		}
	}
}
