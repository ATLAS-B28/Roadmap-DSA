package org.polymorphism;

/*
* Polymorphism is the ability of an object to take on many
* forms. In Java, it allows objects of different classes to
* be treated as objects of a common superclass or interface.
* */
/*
* In runtime polymorphism, the method is called according to the type of object
* that is passed to the method
*
* */
/*
class Animal{
    public void makeSound(){
        System.out.println("Animal makes a sound");
    }
}
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
public class Runtime{
    public static void main(String[] args){
        Animal animal1 = new Animal();
        animal1.makeSound();

        Animal animal2 = new Cat();
        animal2.makeSound();

        Cat cat = new Cat();
        cat.makeSound();
    }

}
*/
class Bike{
    public void run(){
        System.out.println("Bike is running");
    }
}
class Splendor extends Bike{
    public void run(){
        System.out.println("Splendor is running");
    }
}
public class Runtime {
    public static void main(String[] args){
        Bike bike = new Splendor();
        bike.run();
    }
}
/*
* Polymorphism cannot be done with data members unlike methods
* which can be overridden
* So, data members are not polymorphic
* */

