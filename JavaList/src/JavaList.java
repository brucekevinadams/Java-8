/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
This program asks the user how many numbers to enter into an ArrayList. The user then is prompted to either Insert,
Delete, Print, or Quit. Insert (I) will add a number into the ArrayList, Delete (D), will remove the number from
the ArrayList, Print will print the ArrayList to the console, and Quit (Q) will quit the program.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {

    @SuppressWarnings({"rawtypes", "unchecked", "boxing"})
    public static void main(String[] args) {
        // Let us create a list
        List list = new ArrayList();
        System.out.println("How many numbers do you want to insert into a list?");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println("Insert " + n + " numbers.");
        for (int i = 0; i < n; i++) {
            list.add(i, scan.nextInt());
        }

        System.out.println("List: " + list);
        String typing = "";

        while (!(typing.equals("Quit") || typing.equals("Q"))) {
            System.out.println("Type Insert (I), Delete (D), Print (P), or Quit (Q).");
            switch (typing = scan.next()) {
                case "Insert":
                case "I":
                    System.out.println("Insert a number:");
                    int val = scan.nextInt();
                    System.out.println(val);
                    list.add(val);
                    System.out.println(list);
                    break;
                case "Delete":
                case "D":
                    System.out.println("Delete a number:");
                    int del = scan.nextInt();
                    if (list.contains(del)) {
                        Object index = list.indexOf(del);
                        int i = (int) index;
                        // System.out.println(i);
                        list.remove(i);
                    } else
                        System.out.println("No such number exists in the ArrayList!");
                    break;
                case "Print":
                case "P":
                    System.out.println(list.toString());
                    continue;
                case "Quit":
                case "Q":
                case "q":
                    break;
                default:
                    System.out.println("Unknown input");
                    break;
            }
        }

        scan.close();
        System.out.println("ArrayList = " + list.toString());
    }

}

