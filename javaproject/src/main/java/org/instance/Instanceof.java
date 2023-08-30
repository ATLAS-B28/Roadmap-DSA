package org.instance;

class Animal{}
class Dog1 extends Animal{}
public class Instanceof {
    public static void main(String[] args){
        Dog1 d = new Dog1();
        System.out.println(d instanceof Animal);
    }
}
