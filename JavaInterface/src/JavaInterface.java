/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
This program shows how Java Interface can be used with the implements keyword
to instantiate a public method to call the private interface.
This is from the Hackerrank problem Java Interface
*/
import java.util.*;
interface AdvancedArithmetic{
    int divisor_sum(int n);
}
class MyCalculator implements AdvancedArithmetic {
    public int divisor_sum (int n) {
        List list = new ArrayList();
        int sum = n;

        for(int i = 1; i <= n / 2; i++)
        {
            if(n % i == 0) {
                // Let us create a list
                list.add(i);
                sum += i;
            }
        }
        list.add(n);
        System.out.println("Divisors of the integer " + n + " are: " + list);
        return sum;
    }
}
class JavaInterface{
    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print("The sum of the divisors of n are: " + my_calculator.divisor_sum(n) + "\n");
        sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}
