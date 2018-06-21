
/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
Generic methods are a very efficient way to handle multiple datatypes using a single method. This problem will
test your knowledge on Java Generic methods.

Let's say you have an integer array and a string array. You have to write a single method printArray that
can print all the elements of both arrays. The method should be able to accept both integer arrays or string arrays.

*/

import java.lang.reflect.Method;

class Printer {
	// Generic input to printArray
	// the method takes either an Integer, String, Double or any data type
	<T> void printArray(T a[]) {
		for (T obj : a) {
			System.out.println(obj);
		}
	}
	
	//This method will print an input array in a line
	<T> void printArrayLine(T a[]) {
		for (T obj : a) {
			System.out.print(obj+" ");
		}
	}	

}

public class GenericArray {

	public static void main(String args[]) {
		Printer myPrinter = new Printer();
		@SuppressWarnings("boxing")
		Integer[] intArray = { 1, 2, 3 };
		String[] stringArray = { "Hello", "World" };
		@SuppressWarnings("boxing")
		Double[] dblArray = { 1.5, 3.456, 678.9876 };
		myPrinter.printArray(intArray);
		myPrinter.printArray(stringArray);
		myPrinter.printArray(dblArray);
		myPrinter.printArrayLine(intArray);
		myPrinter.printArrayLine(stringArray);
		myPrinter.printArrayLine(dblArray);
		int count = 0;

		for (Method method : Printer.class.getDeclaredMethods()) {
			String name = method.getName();

			if (name.equals("printArray"))
				count++;
		}

		if (count > 1)
			System.out.println("Method overloading is not allowed!");

	}
}
