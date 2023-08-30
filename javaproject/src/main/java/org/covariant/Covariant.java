package org.covariant;

class A{
    A get(){return this;};
}
public class Covariant extends A{
    @Override
    Covariant get(){
        return this;
    }
    void message(){
        System.out.println("Hello");
    }
    public static void main(String[] args){
        new Covariant().get().message();
    }
}
