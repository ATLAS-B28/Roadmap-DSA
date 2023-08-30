package org.abstraction;

//Interface that is a mechanism of abstraction
//it is a blueprint of a class
//it has static constants and abstract methods
//class extends class
//interface implements class
//interface extends interface
interface Vehicle{
    void start();
    void stop();
}
class Car implements Vehicle{
    public void start(){
        System.out.println("Car is started");
    }
    public void stop(){
        System.out.println("Car is stopped");
    }
}
public class Interface {
    public static void main(String[] args){
        Vehicle car = new Car();
        car.start();
        car.stop();
        Car car2 = new Car();
        car2.start();
        car2.stop();
    }
}
