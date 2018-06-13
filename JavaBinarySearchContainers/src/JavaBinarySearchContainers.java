
/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *  
 *  This program shows that the Java Arraylist.contains() method is much faster for binary search
 *  then using Collections.binarySearch(). First, the program uses Arraylist.contains() to
 *  search for the number 5,000,000 and display the time it took in nanoseconds to
 *  find the number. Second, we search for the number 5,000,000
 *  using the Collections.binarySearch method and display the time it took to find.
 *  We compute time in nanoseconds with the method System.nanoTime();
 *  
 *  Results are printed to console, which shows that .contains is much faster 
 *  
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaBinarySearchContainers {

	public static void main(String args[]) {

		// Creating List
		List<Integer> numbers = new ArrayList<Integer>(10000000); // List of 10M records

		// Initializing List of numbers
		for (int i = 0; i < numbers.size(); i++) {
			numbers.add(new Integer(i));
		}

		// Perform using Java .contains method
		long startTime = System.nanoTime();
		numbers.contains(new Integer(5000000)); // Search for 5M number
		long endTime = System.nanoTime();
		System.out.println("For 10M records .contains method binary search took " + (endTime - startTime) + " ns");

		// Perform using Java Collections.binarySearch method
		long startTimeBinary = System.nanoTime();
		Collections.sort(numbers); // List needs to be sorted for Binary Search
		Collections.binarySearch(numbers, new Integer(5000000)); // Search for 5M number
		long endTimeBinary = System.nanoTime();
		System.out.println(
				"For 10M records Collections.binarySearch method took " + (endTimeBinary - startTimeBinary) + " ns");
	}

}
