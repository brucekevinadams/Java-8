/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
This program shows how singleton works and is from a Hackerrank java problem.

*/

class Singleton {
    // static variable single_instance of type Singleton
    private static Singleton single_instance = null;

    // variable of type String
    public String str;

    // private constructor restricted to this class itself
    private Singleton() {
        str = "Hello I am a singleton! Let me say hello world to you";
    }

    // static method to create instance of Singleton class

    public static Singleton getSingleInstance() {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }

}

// Driver Class
class JavaSingleton {
    public static void main(String args[]) {
        // instantiating Singleton class with variable x
        Singleton x = Singleton.getSingleInstance();

        // instantiating Singleton class with variable y
        Singleton y = Singleton.getSingleInstance();

        // instantiating Singleton class with variable z
        Singleton z = Singleton.getSingleInstance();

        // changing variable of instance x
        x.str = (x.str).toUpperCase();

        System.out.println("String from x is " + x.str);
        System.out.println("String from y is " + y.str);
        System.out.println("String from z is " + z.str);
        System.out.println("\n");

        // changing variable of instance z
        z.str = (z.str).toLowerCase();

        System.out.println("String from x is " + x.str);
        System.out.println("String from y is " + y.str);
        System.out.println("String from z is " + z.str);
    }
}