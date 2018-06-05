/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
Function to calculate x raised to the power of y
*/

package XToPowerY;

import java.text.DecimalFormat;
import java.util.Scanner;

public class XToPowerY {

	static class GFG {
		/* Function to calculate x raised to the power y */
		static long power(long x, long y) {
			if (y == 0)
				return 1;
			else if (y % 2 == 0)
				return power(x, y / 2) * power(x, y / 2);
			else
				return x * power(x, y / 2) * power(x, y / 2);
		}

		/* Program to test function power */
		public static void main(String[] args) {

			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			decimalFormat.setGroupingSize(3);
			decimalFormat.setGroupingUsed(true);
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter base number that you want to calculate: ");

			long x = scan.nextInt();
			System.out.print("Enter number to raise " + x + " to: ");
			long y = scan.nextInt();

			System.out.println(x +" raised to the power of " + y + " is : " + decimalFormat.format(power(x,y)));
			scan.close();
		}
	}
}
