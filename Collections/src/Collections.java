/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
This Java 8 program explains collections
*/

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Vector;

public class Collections {
    public static void main(String[] args) {
        // Creating instances of array, vector and hashtable
        int arr[] = new int[]{1, 2, 3, 4};
        Vector<Integer> v = new Vector();
        Hashtable<Integer, String> h = new Hashtable();
        v.addElement(11);
        v.addElement(23);
        h.put(1, "Bruce");
        h.put(2, "Adams");

        // Array instance creation requires [], while Vector
        // and Hashtable require ()
        // Vector element insertion requires addElement(), but
        // hashtable element insertion requires put()

        // Accessing first element of array, vector and hashtable
        System.out.println(arr[0]);
        System.out.println(v.elementAt(0));
        System.out.println(h.get(1));
        System.out.println(h.get(2));
        // Print all elements to console of each collection
        System.out.println();
        System.out.println(Arrays.toString(arr));
        System.out.println(v);
        System.out.println(h);

        // Array elements are accessed using [], vector elements
        // using elementAt() and hashtable elements using get()
    }
}