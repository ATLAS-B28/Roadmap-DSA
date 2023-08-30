package org.methods;

/*
* Overriding occurs when a subclass overrides the
* implementation of a method previously mentioned in
* superclass
* */

class Animal{
    public void makeSound(){
        System.out.println("Animal makes a sound");
    }
}
class Cat extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Meow");
    }
}
public class Overriding {
    public static void main(String[] args){
        Animal animal1 = new Animal();
        animal1.makeSound();

        Cat cat = new Cat();
        cat.makeSound();
    }
}
