package org.generics;

//generic class
//a class that can refer to any type is
//known as a generic class
//<T> is a type parameter to create the generic class
//of specific type

/*class MyGen<T>{
    T obj;
    void add(T obj){
        this.obj = obj;
    }
    T get(){
        return obj;
    }
}
public class Example {
    //using
    public static void main(String[] args){
        MyGen<String> obj = new MyGen<>();
        obj.add("Abhijeet");
        System.out.println(obj.get());
        MyGen<Integer> obj1 = new MyGen<>();
        obj1.add(10);
        System.out.println(obj1.get());
    }
}*/
//Type of parameters
/*
* 1 - Type - commonly used type parameter
* 2 - Element - represents the element type in ds or collections
* 3 - Key - represents the key type in maps
* 4 - Number - represents the number type in maps
*     It is used to enforce that the type parameter
*     must be a subclass of Number
* 5 - Value - typically represents the value type
*     in ds and collections
* */

//Generic methods
//Like the generic class,
// we can create a generic method that
// can accept any type of arguments.
// Here, the scope of arguments is limited to the
// method where it is declared.
// It allows static as well as non-static methods.

//in the example we are using the E type


/*
public class Example{
    public static <E> void printArray(E[] elements){
        for(E element : elements){
            System.out.println(element);
        }
        System.out.println();
    }
    public static void main(String[] args){
        Integer[] intArray = {10,20,30,40,50,60,70};
        Character[] charArray  ={'A','D','I','T','Y','A'};
        printArray(intArray);
        printArray(charArray);
    }
}*/
//Wildcard in Java Generics
/*
* Wildcard in Java Generics
* We can use a wildcard as a type of
* parameter, field, return type, or local
* variable. However, it is not allowed to use
* a wildcard as a type argument for a generic
* method invocation, a generic class instance
*  creation, or a supertype
 */
/*
import java.util.*;
abstract class Shape{
    abstract void draw();
}
class Rectangle extends Shape{
    void draw(){
        System.out.println("Rectangle");
    }
}
class Circle extends Shape{
    void draw(){
        System.out.println("Circle");
    }
}
class Square extends Shape{
    void draw(){
        System.out.println("Square");
    }
}
//a method to accept the child of shape class only
//another class
public class Example{
    public static void drawShape(List<? extends Shape> lists){
        for(Shape a : lists){
            a.draw();
        }
    }
    public static void main(String[] args){
        List<Rectangle> r = new ArrayList<>();
        r.add(new Rectangle());//<- rectangle object instance
        List<Circle> c = new ArrayList<>();
        c.add(new Circle());//<- circle object instance
        c.add(new Circle());
        List<Square> sq = new ArrayList<>();
        sq.add(new Square());
        drawShape(r);
        drawShape(c);
        drawShape(sq);

    }
}
//with upperbounded wildcards one can read the elements
//but not add unless we clearly specify the type
//like above we have List<Square> - i.e. the type is Square*/

//unbounded wildcard
/*
import java.util.*;

class Unbounded{
    public static void display(List<?> list){
        for(Object o:list){
            System.out.println(o);
        }
    }
}
public class Example{
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        Unbounded.display(list);
        List<String> list1 = new ArrayList<>();
        list1.add("Abhijeet");
        list1.add("Aditya");
        Unbounded.display(list1);
    }
}*/

//lower bounded wildcard
/*The purpose of lower bounded wildcards is to
 restrict the unknown type to be a specific type
  or a supertype of that type. It is used by
  declaring wildcard character ("?") followed
  by the super keyword, followed by its lower
  bound.
*/

import java.util.*;
class LowerBounded{
    public static void display(List<? super Integer> list){
        for(Object o:list){
            System.out.println(o);
        }
    }
}
public class Example{
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        LowerBounded.display(list);
        //List<String> list1 = new ArrayList<>();
        //list1.add("Abhijeet");
        //list1.add("Aditya");
        //LowerBounded.display(list1); //incompatible types with integer
    }
}