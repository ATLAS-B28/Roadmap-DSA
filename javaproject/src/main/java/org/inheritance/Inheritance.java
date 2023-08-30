package org.inheritance;

class Employee{
    String name;
    int age;
    Employee(String name,int age){
        this.name = name;
        this.age = age;
    }
    void Display(){
        System.out.println("Name: "+name+", Age: "+age+"\n");
    }
}

class Programmer  extends Employee{
    int id;
    Programmer(String name,int age, int id){
        super(name,age);
        this.id = id;
    }
    void Display(){
        System.out.println("Name: "+name+", Age: "+age+", Id: "+id+"\n");
    }
}
public class Inheritance {
    Employee emp = new Employee("Aditya",21);
    Programmer pro = new Programmer("Aditya",21,2);
    public static void main(String[] args){
        Inheritance obj = new Inheritance();
        obj.emp.Display();
        obj.pro.Display();
    }
}
/*
* 1 - Single Inheritance
* 2 - Multiple Inheritance
* 3 - Hierarchical Inheritance
* 4 -  Multiple Level Inheritance
* 5 - Hybrid Inheritance
* */

