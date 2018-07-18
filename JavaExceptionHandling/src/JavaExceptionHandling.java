/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
This program shows how Exception Handling in Java works and is from a Hackerrank java problem.
The Java try/catch block is used for error handling. The user will enter two integers and divide the first
by the second. This code is placed in the try block, andif something goes wrong, such as dividing an integer by 0,
or the user inputs a string when an integeris expected, then the catch block is called, and the program terminates.

In this program there are two catch blocks, the first is InputMismatchException, which will catch when non-integers
are input by the user, such as entering a letter or special character when an int was expected. The second catch block
uses catch (ArithmeticException e) to discover if the user is attempting to divide by zero, which will be caught.

Normally, the InputMismatchException block would look like this:
       } catch (InputMismatchException e) {
            System.out.println(e);
       }
       
But, in Hackerrank,  this fails Test Case 4, so a hard-coded message is necessary. In the real world, this
is considered bad practice.


Sample Input   Sample Input                                    Sample Input
10                 10                                              10
3                   0                                              hello

Sample Output  Sample Output                                   Sample Output
3               java.lang.ArithmeticException: / by zero        java.util.InputMismatchException
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionHandling {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        try {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int ans = x / y;
            System.out.println(ans);
        } catch (InputMismatchException e) {
            System.out.println("java.util.InputMismatchException\n");
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        sc.close();
    }
}
