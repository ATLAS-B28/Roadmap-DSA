package org.inheritance;

public class Emp {
    int id;
    int age;
    String name;
    Address address;
    public Emp(int id, String name,int age, Address address){
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }
    void display(){
        System.out.println("Name: "+name+", Age: "+age+", Id: "+id+"\n");
        System.out.println(address.city+", "+address.state+", "+address.country+"\n");
    }
    public static void main(String[] args){
        Emp obj = new Emp(1,"Abhijeet",21,new Address("Pune","Maharashtra","India"));
        obj.display();
    }
}
