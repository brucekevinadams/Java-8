/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
This program uses an Abstract Classs to show how it cannot be instantiated, but must have inherited Classes
 using the extends keyword to instantiate a non-Abstract class.
 This is from the Hackerrank problem Java Abstract Class.
*/

import java.util.Scanner;

abstract class Book {
    String title;

    abstract void setTitle(String s);

    String getTitle() {
        return title;
    }
}

//Write MyBook class here
class MyBook extends Book {
    String title;

    void setTitle(String s) {
        title = s;
    }

    String getTitle() {
        return title;
    }

}

public class JavaAbstractClass {

    public static void main(String[] args) {
        //Book new_novel=new Book(); This line prHMain.java:25: error: Book is abstract; cannot be instantiated
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        MyBook new_novel = new MyBook();
        new_novel.setTitle(title);
        System.out.println("The title is: " + new_novel.getTitle());
        sc.close();

    }
}