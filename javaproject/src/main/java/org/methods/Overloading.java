package org.methods;

import java.util.Calendar;

class Calculator{
    public int add(int a,int b){
        return a + b;
    }
    public double add(double a, double b){
        return a + b;
    }
}
public class Overloading {
    public static void main(String[] args){
        Calculator cal = new Calculator();
        int sum1 = cal.add(2,3);
        double sum2 = cal.add(2.5,4.6);
        System.out.println(sum1);
        System.out.println(sum2);
    }
}
