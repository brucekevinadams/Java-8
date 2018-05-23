/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
 * The task is to divide a array into two sub array (left and right) containing n/2 elements
 *  each and do the sum of the subarrays and then multiply both the subarrays.

Input:
First line consists of T test cases. Only line of every test case consists of an integer N.​

Output:
Print the answer by dividing array into left and right array and add their elements individually
 and then multiply both the array

Constraints:
1<=T<=100
1<=N<=1000
1<=Ai<=100
 */

import java.util.Scanner;

public class ArrayAddSubLeftRightAndMultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int tests = in.nextInt();
		int sumArray[] = new int[tests];

		for (int j = 0; j < tests; j++) {

			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}

			int size = arr.length;
			int middle = size / 2;
			int leftSum = 0;
			int rightSum = 0;

			for (int i = 0; i < middle; i++) {
				leftSum += arr[i];
			}
			for (int i = middle; i < size; i++) {
				rightSum += arr[i];
			}

			int mult = leftSum * rightSum;
			sumArray[j] = mult;
		}

		for (int i = 0; i < tests; i++) {
			System.out.println(sumArray[i]);
		}

		in.close();
	}
}
