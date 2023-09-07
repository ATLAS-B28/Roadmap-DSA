package Sorting;

import java.util.Arrays;

// bubble, selection and insertion
public class BSI {

    public static void main(String[] args){
        //bubble sort
        int[] array = {5,2,8,1,9,3,7,4,6};
        int n = array.length;
        /*for(int i=0; i< n-1; i++){
            for(int j=0; j < n-i-1 ; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }*/
        //selection sort
        /*for(int i=0; i<n-1; i++){
            int minIndex = i;
            for(int j=i+1; j<n; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }*/
        //insertion sort
        for(int i=1; i<n; i++){
            int key = array[i];
            int j = i-1;
            while(j>=0 && array[j] > key){
                array[j+1]  =array[j];
                j--;
            }
            array[j+1] = key;
        }
        System.out.println(Arrays.toString(array));
    }
}
