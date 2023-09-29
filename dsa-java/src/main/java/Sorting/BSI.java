package Sorting;

import java.util.Arrays;

// bubble, selection and insertion
public class BSI {

    public static void main(String[] args){
        //bubble sort
        int[] array = {5,2,8,1,9,7,3,4,6};
        int n = array.length;
        /*for(int i=0; i< n-1; i++){
            for(int j=0; j < n-i-1 ; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        /*
        //selection sort
        for(int i=0; i<n-1; i++){//it is boundary between unsorted and sorted
            int minIndex = i;//min. index in unsorted part of array
            for(int j=i+1; j<n; j++){//searches from i+1 to n i.e. the unsorted portion
                if(array[j] < array[minIndex]){
                    minIndex = j;//if jth < small then current minIndex
                    //update the minIndex to jth index
                }
            }
            int temp = array[minIndex];//new value of minIndex
            array[minIndex] = array[i];//update the value of minIndex with ith element
            array[i] = temp;//then set the actual min. value of ith element to
                            // the start of the sorted
        }*/

        //insertion sort
        for(int i=1; i<n; i++){//starts from 2nd element to last and is unsorted portion
            int key = array[i];//the key element is ith element and
            //will be inserted in the sorted portion
            int j = i-1;//one position behind i ,and it is last of sorted portion
            while(j>=0 && array[j] > key){//so the sorted portion is from 0 to j
                //and also jth element is greater than key i.e. previous(jth) is greater
                //then present(ith)
                array[j+1]  = array[j];//this shifts the larger element one position ahead
                //and makes space for key
                j--;//moves previous element to sorted portion
            }
            array[j+1] = key;//if j = -1 or j is not < key then key is inserted at j+1
            //which is its correct position
        }
        System.out.println(Arrays.toString(array));
    }
}
