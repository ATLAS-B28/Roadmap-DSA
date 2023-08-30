package org.program1;

public class Conditionals {
    public static void main(String[] args){
        int x =9;
        int y =8;
        if (x>y){
            System.out.print("x is greater than y\n");
        }
        int time =20;
        if(time < 18){
            System.out.print("Good day\n");
        }else {
            System.out.print("Good evening\n");
        }
        int time2 = 14;
        if(time2 <10){
            System.out.println("Good morning\n");
        }else if (time2 < 18){
            System.out.println("Good day\n");
        }else{
            System.out.println("Good evening\n");
        }
        int time3= 20;
        String result = (time3 < 18)? "Good day\n":"Good evening\n";
        System.out.println(result);

    }
}
