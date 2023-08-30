package org.program1;

public class Main2 {
  public static void main(String[] args){
      int num = 5;
      float floatNum = 5.99f;
      char letter = 'A';
      boolean myBool = true;
      String myText = "Hello";
      System.out.print("Hello from 2nd main class from the org ");
      System.out.print("A number "+num+" \n");
      System.out.print("A letter "+letter+" \n");
      System.out.print("A float number "+floatNum+" \n");
      System.out.print("A boolean "+myBool+" \n");
      System.out.print("A text "+myText+" \n");
      int myInt = (int) floatNum;
      System.out.print("From float to int "+myInt);
      int x  =5;
      x &= 3;
      System.out.print(x);
  }
}

