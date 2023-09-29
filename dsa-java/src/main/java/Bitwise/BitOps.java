package Bitwise;
//here the binary versions of the integers are operated upon
public class BitOps {
    public static void main(String[] args) {
        int a= 3;// 0011
        int b = 5;// 0101
        int result1 = a & b; // binary 0001
        int result2 = a | b; // binary 0111
        int result3 = a ^ b; // binary 0110 XOR operator
        int result4 = ~a;  // binary 1110 NOT operator
        int result = a << 2;// binary 1100 shift left
        int result5 = b >> 2;// binary 1100 shift right
        int c = -10;
        int d = -20;
        int result6 = c >> 2;
        int result7 = c >>> 2;//unsigned right shift
        int result8 = d << 2;
        int result9 = d >> 2;
        int result10 = d >>> 2;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
        System.out.println(result9);
        System.out.println(result10);

    }
}
