package org.binding;

/*
* Dynamic Binding - Dynamic binding happens during runtime.
* It happens when the runtime can determine the method implementation to be called
* based on the type of the object at runtime. Dynamic binding is typically
* applied to overridden methods.
* or
* Dynamic binding, also known as late binding, is the process of
* determining the actual implementation of a method to be called at
* runtime based on the type of the actual object, rather than the
* type of the reference variable.
* */
class Animal4 {
    public void makeSound(){

        System.out.println("Animal makes a sound");
    }
}
class Cat4 extends Animal4 {
    @Override
    public void makeSound(){
        System.out.println("Meow");
    }
}
public class Dynamic {
    public static void main(String[] args){
        Animal4 animal = new Cat4(); //here we do dynamic binding so the type of object is used to do the
        //binding ,therefore we do it this way
        animal.makeSound();
    }
}
