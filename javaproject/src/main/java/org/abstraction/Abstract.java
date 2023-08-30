package org.abstraction;

/*
* Points to Remember
An abstract class must be declared with an abstract keyword.
It can have abstract and non-abstract methods.
It cannot be instantiated.
It can have constructors and static methods also.
It can have final methods which will force the
subclass not to change the body of the method.
* */

abstract class Bike{
    Bike(){
        System.out.println("Bike is running");
    }
    abstract void run();
    void stop(){
        System.out.println("Bike is stopped");
    }
}
class Apache extends Bike{
    void run(){
        System.out.println("Apache is running");
    }
}
public class Abstract {
    public static void main(String[] args){
        Bike bike = new Apache();
        bike.run();
        bike.stop();
    }
}
