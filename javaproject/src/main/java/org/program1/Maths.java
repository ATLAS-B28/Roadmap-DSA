package org.program1;

public class Maths {
    public static void main(String[] manin){
        System.out.print("Assignment Operators \n");
        //+=
        int x =5;
        x += 3;
        System.out.print("+= operator " +x+"\n");
        //-=
        int y = 9;
        y -=3;
        System.out.print("-= operator "+y+"\n");
        //*=
        int a = 9;
        a *= 6;
        System.out.print("*= operator "+a+"\n");
        // /=
        int b = 8;
        b /= 4;
        System.out.print("*= operator "+b+"\n");
        // %=
        int c = 30;
        c %= 4;
        System.out.print("%= operator "+c+"\n");
        // &=
        int d = 5;  // binary: 0101
        int e = 3;  // binary: 0011
        d &= e;
        System.out.print("BITWISE And operator "+d+"\n");
        // |=
        int f = 6;
        int g = 3;
        f |= g;
        System.out.print("BITWISE Or operator "+f+"\n");
        // ^=
        int h = 5;
        int i = 8;
        i ^= h;
        System.out.print("BITWISE Xor operator "+i+"\n");
        // >>= and <<=
        int j =10;
        j >>= 2;
        System.out.print("Right shift "+j+"\n");
        int k = 20;
        k >>= 2;
        System.out.print("Left shift "+k+"\n");
        System.out.print("\nMaths operator\n ");
        //max
        System.out.print(Math.max(4,8)+"\n");
        //min
        System.out.print(Math.min(9,3)+"\n");
        //sqrt
        System.out.print(Math.sqrt(9));
        //abs
        System.out.print(-8.21+"\n");



    }


}
