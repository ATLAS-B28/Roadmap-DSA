package org.objectclass;

class Car{
    String make;
    String model;
    int year;
    public void startEngine(){
        System.out.println("Start engine");
    }
    public void printInfo(){
        System.out.println("Company "+make+", Model "+model+", Year "+year+"\n");
    }
}
public class Object {
    public static void main(String[] args){
        Car car1 = new Car();
        Car car2 = new Car();
        car1.make = "Tata";
        car1.model = "Harrier";
        car1.year = 2022;
        car2.make = "Honda";
        car2.model = "Accord";
        car2.year = 2019;
        car1.startEngine();
        car1.printInfo();
        car2.startEngine();
        car2.printInfo();
        Student s1 = new Student("Aditya",21);
        s1.Display();
        Student1 s2 = new Student1("Aditya",21);
        s2.Display();
        Student1 s3 = new Student1(2,"Aditya",21);
        s3.Display();
    }
}
// parameterized contructor
class Student{
    String name;
    int age;
    Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    void Display(){
        System.out.println("Name: "+name+", Age: "+age+"\n");
    }

}

//overloading the constructor
class Student1{
    String name;
    int age;
    int id;
    Student1(String name,int age){
        this.name = name;
        this.age = age;
    }
    Student1(int id,String name, int age){
        this.id = id;
        this.age = age;
        this.name = name;
    }
    void Display(){
        System.out.println("Name: "+name+", Age: "+age+", Id: "+id+"\n");
    }
}
/*
* Usage of Java this keyword
Here is given the 6 usage of java this keyword.

this can be used to refer current class instance variable.
this can be used to invoke current class method (implicitly)
this() can be used to invoke current class constructor.
this can be passed as an argument in the method call.
this can be passed as argument in the constructor call.
this can be used to return the current class instance from the method.
* */

