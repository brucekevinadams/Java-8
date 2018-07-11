/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 * 
This Java 8 program uses TreeMap and SortedMap to create a phone book. The user is asked for the number of people 
to enter into the phone book.

Then, the user enters the name, followed by the phone number. All data is stored as Strings and sorted using SortedMap.
Next, the user is queried whether to Insert (I) a name, Delete (D) a name, Print (P) the phonebook, or Quit (Q).

*/

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class JavaMap {


    @SuppressWarnings("boxing")
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of people to enter into the database: ");
        int n = in.nextInt();
        in.nextLine();
        SortedMap<String, String> hm = new TreeMap<String, String>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of the person at index " + i + ": ");
            String name = in.nextLine();
            System.out.println("Enter the phone number: ");
            String phone = in.nextLine();
            hm.put(name, phone);
        }

        String typing = "";

        while (!(typing.equals("Quit") || typing.equals("Q") || typing.equals("q"))) {
            System.out.println("Type Insert (I), Delete (D), Print (P) or Quit (Q).");
            switch (typing = in.nextLine()) {
                case "Insert":
                case "I":
                    System.out.println("Insert the persons name:");
                    String name = in.nextLine();
                    System.out.println("Enter the phone number: ");
                    String phone = in.nextLine();
                    hm.put(name, phone);
                    break;
                case "Delete":
                case "D":
                    System.out.println("Delete a person from the phonebook:");
                    String delName = in.nextLine();
                    try {
                        String temp = hm.get(delName);
                        if (temp == null)
                            System.out.println("That name is not in the phonebook!");
                        else
                            hm.remove(delName);
                    } catch (NullPointerException e) {
                        System.out.println(delName + " Not found!");
                    }
                    break;
                case "Print":
                case "P":
                    System.out.println("Phone Book: " + hm);
                    break;
                case "Quit":
                case "Q":
                case "q":
                    break;
                default:
                    System.out.println("Unknown input");
                    break;
            }
        }
        in.close();
    }
}
