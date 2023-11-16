package array_string;

import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) throws Throwable {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        int[] unSorted = {10,9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(unSorted));

        int len = unSorted.length;
        System.out.println("Length of unsorted array_string: "+len);

        for(int i : numbers){
            System.out.println(i);
        }

        Arrays.sort(unSorted);
        System.out.println(Arrays.toString(unSorted));

        int max = unSorted[len-1];
        int min = unSorted[0];
        System.out.println("Max: "+max);
        System.out.println("Min: "+min);

        int sum = 0;
        for(int i : unSorted){
            sum+=i;
            System.out.println("Sum every iteration: "+sum);
        }

        int sub = 0;
        for(int i : numbers){
            sub-=i;
            System.out.println("Subtract every iteration: "+sub);
        }

        System.out.println("Sum: "+sum);
        System.out.println("Subtract: "+sub);

        int[] numbers2 = {1,2,3,4,5,6,7,8,9,10};
        int[] unSorted2 = {10,9,8,7,6,5,4,3,2,1};

        System.out.println(Arrays.toString(numbers2));
        System.out.println(Arrays.toString(unSorted2));

        int[] newArray = Arrays.copyOf(unSorted2, 20);
        System.out.println(Arrays.toString(newArray));

        String[] stringName = {"Aditya", "Bhambere"};
        if(Arrays.equals(stringName,new String[] {"Aditya", "Bhambere"})){
            System.out.println("Equal");
        }else{
            System.out.println("Not equal");
        }
    }
}
