/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
In computer science, a set is an abstract data type that can store certain values, without any particular order,
and no repeated values(Wikipedia). {1,2,3} is an example of a set, but {1,2,2} is not a set. Today you will learn
how to use sets in java by solving this problem.

You are given pairs of strings. Two pairs (a,b) and (c,d) are identical if a=c and b=d. That also implies (a,b) is
not the same as (b,a). After taking each pair as input, you need to print number of unique pairs you currently have.

Complete the code in the editor to solve this problem.

Input Format

In the first line, there will be an integer t denoting number of pairs. Each of the next t lines will contain
two strings separated by a single space.

Constraints:

	1 <= t <= 100000
    Length of each string is at most 5 and will consist lower case letters only.

Output Format

Print t lines. In the I'th line, print number of unique pairs you have after taking I'th pair as input.

*/

import java.util.HashSet;
import java.util.Scanner;

public class JavaHashSet {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		String [] pair_left = new String[t];
		String [] pair_right = new String[t];
		
		for (int i=0; i < t; i++) {
			pair_left[i] = s.next();
			pair_right[i] = s.next();
		}
		
	    HashSet<String> pairs = new HashSet<String>(t);

	    for(int i = 0; i < t; i++)
	    {
	        pairs.add("(" + pair_left[i] + ", " + pair_right[i] + ")" );
	        System.out.println(pairs.size());        
	    }
	    
	    s.close();
	}

}
