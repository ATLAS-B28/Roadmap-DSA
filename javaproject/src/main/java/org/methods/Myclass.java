package org.methods;

public class Myclass {
    private void privateMethod() {
        System.out.println("Private method");
    }

    public void publicMethod() {
        System.out.println("Public method");
    }
}

 class AnotherClass {
    public void someMethod() {
        Myclass obj = new Myclass();
        //obj.privateMethod();  // Not accessible, will result in a compilation error

        obj.publicMethod();  // Accessible, can be called from AnotherClass
    }
}

 class Subclass extends Myclass {
    public void someMethod() {
        //privateMethod();  // Not accessible, will result in a compilation error

        publicMethod();  // Accessible, can be called from Subclass
    }
}
