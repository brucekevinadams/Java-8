/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
This program shows how Java super keyword works to invoke a superclass method.
*/

class BiCycle {
    String define_me() {
        return "a vehicle with pedals.";
    }
}

class MotorCycle extends BiCycle {
    String define_me() {
        return "a cycle with an engine.";
    }

    MotorCycle() {
        System.out.println("Hello I am a motorcycle, I am " + define_me());
        // temp uses the super keyword to implement the superclass BiCycle
        // String define_me instead of the subclass Motorcycle define_me method
        String temp = super.define_me();
        System.out.println("My ancestor is a cycle who is " + temp);
    }

}

class Solution{
    public static void main(String[] args) {
        MotorCycle M = new MotorCycle();
    }
}
