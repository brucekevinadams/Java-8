import java.util.*;

public class LibraryFine {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner jin = new Scanner(System.in);
		int day = jin.nextInt();
		int month = jin.nextInt();
		int year = jin.nextInt();
		int expDay = jin.nextInt();
		int expMonth = jin.nextInt();
		int yearExpected = jin.nextInt();

		int fine = 0;

		if (year > yearExpected) {
			fine = 10000;
		} else if (year == yearExpected && month > expMonth) {
			fine = (month - expMonth) * 500;
		} else if (year == yearExpected && month == expMonth && day > expDay) {
			fine = (day - expDay) * 15;
		}

		System.out.println(fine);
	}

}