package org.instance;

/*class Animal6{
    public static void eat(){
        System.out.println("Animal eats");
    }
}*/

/*class Cat extends Animal6{
    public static void eat(){
        System.out.println("Cat eats");
    }
    public static void meow(){
        System.out.println("Cat eats");
    }
}*/
class Animal7{
    public void eat(){
        System.out.println("Animal eats");
    }
}
class Cat2 extends Animal7{
    //public void meow(){
      //  System.out.println("Meow");
    //}
    public void eat(){
        System.out.println("Cat eats");
    }
}
public class Downcasting {
    public static void main(String[] args) {
        //Animal6 a = new Cat();//upcasting
        //a.eat();
        // |
        // |
        //\|/
        //Animal6.eat();
        //Animal7 animal = (Animal7) new Cat2();  //upcasting
       //if(animal instanceof Animal7) {
         //  animal.eat();
       //}
       Animal7 animal2 = new Cat2();
       Cat2 cat = (Cat2)animal2;
       cat.eat();
       animal2.eat();

    }
}
