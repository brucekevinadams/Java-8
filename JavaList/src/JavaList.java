/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
This program asks the user to input a number (n), which is the number of integers the user enters on 
the next line. The numbers are then inserted into a list.
*/

import java.util.*;

public class JavaList {

	@SuppressWarnings({ "rawtypes", "unchecked", "boxing" })
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		// Let us create a list
		List list = new ArrayList();
		// Array for insertion
		int arr[] = new int[2];

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			list.add(i, scan.nextInt());
		}

		int queries = scan.nextInt();

		while (queries > 0) {
			// System.out.println("Queries = " + queries);

			String com = scan.next();
			switch (com) {

			case "Insert":
				// System.out.println("Insert called");
				int index = scan.nextInt();
				int val = scan.nextInt();
				list.add(index, val);
				break;

			case "Delete":
				// System.out.println("Delete called");
				int del = scan.nextInt();
				list.remove(del);
				break;

			default:
				break;

			}
			queries--;
		}

		scan.close();

		System.out.println(list.toString().replace("[", "").replace("]", "").replace(",", ""));
	}
}
