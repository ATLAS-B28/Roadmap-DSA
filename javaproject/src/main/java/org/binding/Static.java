package org.binding;

/*
* Binding in programming refers to
* the process of connecting a method call to
* the actual method body that should be executed.
* It determines which implementation of a method should be
* invoked based on the type of the object at runtime.
* Binding is an important concept in polymorphism as it allows the appropriate
* method implementation to be connected to the method call,
* enabling the execution of the correct code based on the object's type.
* */

/*
* Static Binding: Static binding happens during
*  compile-time. It occurs when the compiler can
* determine the method implementation to be called
* based on the type of the reference variable.
 * */
class Animal{
    public static void makeSound(){
        System.out.println("Animal makes a sound");
    }
}
class Cat extends Animal {
    public static void makeSound(){
        System.out.println("Meow");
    }
}
public class Static{
    public static void main(String[] args){
        Animal.makeSound(); // here we call it this as the methods are static type and statically bind
        Cat.makeSound();
    }
}

/*
* Static function has static binding as it is associated
* with class itself and not its object.The binding is determined based
* on the static type of the reference variable. Since static methods belong to the
*  class and not to any specific object, the compiler can resolve
* the method call at compile-time.
* */
/*
* Final methods: Final methods are also bound at compile-time because
* they cannot be overridden by subclasses.
 * */
/*
* Private methods: Private methods are bound at compile-time because they
* cannot be accessed or overridden by subclasses. Since private methods
* are not visible to other classes, the method call is resolved at compile-time
* based on the static type of the reference variable.
* */
/*
* Overloaded methods: Overloaded methods are bound at compile-time because the decision
*  of which overloaded method to call
* determined by the static types of the arguments passed to the method.
* The compiler matches the method call with the method definition
*  based on the number, types, and order of the arguments, and resolves the method call at compile-time.
* */