/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
Calculate and print the extra long factorial of a given integer.

Note: Factorials of n > 20 can't be stored even in 64 - bit long long variable. Big integers must be used for
such calculations. Languages like Java, Python, Ruby etc. can handle big integers, but we need to write
additional code in C/C++ to handle huge values.

Input Format

Input consists of a single integer

Constraints
1 <= n <= 100

Output Format

Print the factorial of n.

Sample Input
25

Sample Output
15511210043330985984000000


*/

import java.util.Scanner;

public class FactorialsExtraLong {

	@SuppressWarnings("boxing")
	static void extraLongFactorials(int n) {

		int arr[] = new int[1000];
		arr[0] = 1;
		int len = 1;
		for (int i = 2; i <= n; i++) {
			int carry = 0;
			for (int j = 0; j < len; j++) {
				int mul = i * arr[j] + carry;
				int dig = mul % 10;
				arr[j] = dig;
				carry = mul / 10;
			}

			while (carry > 0) {
				len++;
				int dig = carry % 10;
				arr[len - 1] = dig;
				carry /= 10;
			}
		}

		for (int i = len - 1; i >= 0; i--) {
			System.out.printf("%d", arr[i]);
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		extraLongFactorials(n);

		scanner.close();
	}

}
