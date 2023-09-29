package Bitwise;

public class Mask {
    public static void main(String[] args){
        int value = 0b11011010;//binary : 218
        int mask = 0b00001111;//binary : 15
        int result1 = value & mask; //used to extract a particular bit
        int value1 = 0b11011010;     // binary: 218
        int mask1 = 0b00000101;      // binary: 5
        int result2 = value1 | mask1; //used to change a particular bit to 1
                                      // and others are left unchanged
        int mask3 = ~value;
        String binary = Integer.toBinaryString(mask3);//toggle 0s to 1s and vice-versa
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(binary);
    }
}
