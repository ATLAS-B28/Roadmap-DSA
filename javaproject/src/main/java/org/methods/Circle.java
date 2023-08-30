package org.methods;

public class Circle {
    private double radius;
    public double calculateArea(){
        return Math.PI + radius * radius;

    }
    public static boolean compareArea(Circle circle1,Circle circle2){
        double area1= circle1.calculateArea();
        // non-static is only called on instance of class
        double area2 = circle2.calculateArea();
        return area1 == area2;
    }
    public static void main(String[] args){
        Circle circle1 = new Circle();
        circle1.radius = 4.9;
        Circle circle2 = new Circle();
        circle2.radius = 3.8;
        boolean areTheyEqual = Circle.compareArea(circle1,circle2);
        //static method called direclty on instance of class
        System.out.println(areTheyEqual);
    }
}

