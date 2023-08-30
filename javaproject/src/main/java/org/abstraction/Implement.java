package org.abstraction;

abstract class Implement2 implements Interface2 {
    public void a2(){
        System.out.println("a2");
    }

}
class Implement3 extends Implement2{
    public void a2(){
        System.out.println("a2 again");
    }
    public void b2 (){
       System.out.println("b2");
    }
    public void c2 (){
        System.out.println("c2");
    }
}
public class Implement{
    public static void main(String[] args){
        Interface2 obj = new Implement3();
        obj.a2();
        obj.b2();
        obj.c2();
    }
}
