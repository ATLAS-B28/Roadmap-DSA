package Bitwise;

public class Add{
   public static void main(String[] args){
       int a = 5;
       int b = 3;
       int c = -20;
       int sum = a^b;
       int sum2 = a^c;
       int carry = (a&b)<<1;
       int carry2 = (a&c)<<1;
       int twoCompliment = ~b+1;
       int diff = a & twoCompliment;
       while(carry!=0){
           int tempSum = sum;
           int tempCarry = carry;
           sum = tempSum^tempCarry;
           carry = (tempSum&tempCarry)<<1;
       }
       while(carry2!=0){
           int tempSum = sum2;
           int tempCarry = carry2;
           sum2 = tempSum^tempCarry;
           carry2 = (tempSum&tempCarry)<<1;
       }
       System.out.println(sum);
       String ab = Integer.toBinaryString(a);
       String bb = Integer.toBinaryString(b);
       String cb =  Integer.toBinaryString(c);
       String binary = Integer.toBinaryString(sum);
       String binary2 = Integer.toBinaryString(sum2);
       System.out.println("By adding the 2 binary numbers: \n" + ab + " + " + bb + " = " + binary);
       System.out.println(binary.length());
       System.out.println("By adding the 2 binary numbers: \n" + ab + " + " + cb + " = " + binary2);
       System.out.println(binary2.length());
       System.out.println("Difference of the 2 binary numbers: \n" + ab + " - " + bb + " = " + Integer.toBinaryString(diff));
   }

}
