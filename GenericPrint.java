import java.util.Scanner;

//   Method Name: printArray
//   Print each element of the generic array on a new line. Do not return anything.
//   @param A generic array

class Printer<T> {
	// Write your code here
	public static <T> void printArray(T[] arr) {
		for (T element : arr) {
			System.out.println(element);
		}
	}
}

public class GenericPrint {

	@SuppressWarnings("boxing")
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Integer[] intArray = new Integer[n];
		for (int i = 0; i < n; i++) {
			intArray[i] = scanner.nextInt();
		}

		n = scanner.nextInt();
		String[] stringArray = new String[n];
		for (int i = 0; i < n; i++) {
			stringArray[i] = scanner.next();
		}

		new Printer<Integer>();
		new Printer<String>();
		Printer.printArray(intArray);
		Printer.printArray(stringArray);
		if (Printer.class.getDeclaredMethods().length > 1) {
			System.out.println("The Printer class should only have 1 method named printArray.");
		}
		scanner.close();
	}
}