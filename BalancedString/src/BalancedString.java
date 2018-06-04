/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. 
If A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input Format

There will be multiple lines in the input file, each having a single non-empty string. 
You should read input till end-of-file.

The part of the code that handles input operation is already provided in the editor.

Output Format

For each case, print 'true' if the string is balanced, 'false' otherwise.

*/

import java.util.*;

public class BalancedString {

	@SuppressWarnings("boxing")
	static boolean isBalanced(String in) {
		Stack<Character> st = new Stack<Character>();

		for (char chr : in.toCharArray()) {
			switch (chr) {

			case '{':
			case '(':
			case '[':
				st.push(chr);
				break;

			case ']':
				if (st.isEmpty() || st.pop() != '[')
					return false;
				break;
			case ')':
				if (st.isEmpty() || st.pop() != '(')
					return false;
				break;
			case '}':
				if (st.isEmpty() || st.pop() != '{')
					return false;
				break;
			default:
				break;
			}
		}
		return st.isEmpty();
	}

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			if (isBalanced(input))
				System.out.println("true");
			else
				System.out.println("false");
		}
		sc.close();

	}
}