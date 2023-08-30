package array;

import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5,8,9,11,12,7,6 };
        //access
        int first = numbers[0];
        System.out.println(first);
        //length
        int len = numbers.length;
        System.out.println(len);
        //modifying
        numbers[9] = 0;
        System.out.println(numbers[9]);
        for(int number: numbers){
            System.out.println(number+" ");
        }
        System.out.println();
        //sorting
        Arrays.sort(numbers);
        for(int number: numbers){
            System.out.println(number+" ");
        }
        //searching
        int searchKey = 8;
        int index  = Arrays.binarySearch(numbers, searchKey);
        if (index>=0){
            System.out.println(searchKey+" found at index "+index);
        }else{
            System.out.println(searchKey+" not found");
        }
        int[] copying = Arrays.copyOf(numbers, numbers.length);
        System.out.println(Arrays.toString(copying));

    }
}
