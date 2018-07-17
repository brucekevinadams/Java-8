/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
This program shows how iterator and instanceof works and is from a Hackerrank java problem.
The Class Iterator has the method func which takes the ArrayList mylist as a parameter.
The Java instanceof operator is used to test if the object or instance is a String. If true,
it breaks out of the iterator while loop and returns control back to main().
In this problem we have given you three classes in the editor:
Student class
Rockstar class
Hacker class

In the main method, we populated an ArrayList with several instances of these classes.
Count method calculates how many instances of each type is present in the ArrayList.
The code prints three integers, the number of instance of Student class, the number of instance of Rockstar class,
the number of instance of Hacker class.

Sample Input

2 2
42
10
hello
java

Sample Output

hello
java
*/


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class JavaIterator {

    static Iterator func(ArrayList mylist) {
        Iterator it = mylist.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            if (element instanceof String)//Hints: use instanceof operator

                break;
        }
        return it;

    }

    @SuppressWarnings({"unchecked"})
    public static void main(String[] args) {
        ArrayList mylist = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            mylist.add(sc.nextInt());
        }

        mylist.add("###");
        for (int i = 0; i < m; i++) {
            mylist.add(sc.next());
        }

        Iterator it = func(mylist);
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println((String) element);
        }
    }
}