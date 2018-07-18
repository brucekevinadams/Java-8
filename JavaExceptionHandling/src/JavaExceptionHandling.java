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