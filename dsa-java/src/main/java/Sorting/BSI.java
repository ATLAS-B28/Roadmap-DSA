package Sorting;

import java.util.Arrays;

// bubble, selection and insertion
public class BSI {

    public static void main(String[] args){
        //bubble sort
        int[] array = {5,2,8,1,9,7,3,4,6};
        int n = array.length;
        /*for(int i = 0; i < n - 1; i++) {//outer loop from 0 to n-1
            for(int j = 0; j < n-i-1; j++) {//inner loop the no.of iterations decrease as outer goes on increasing
                //as the size of unsorted goes on reducing, and it will go from 0 to n-1-i here -1-i is
                //added and subtracted from the length giving the current length of unsorted part
                if(array[j] > array[j+1]) {//here see if the succeeding element in the unsorted part aka j+1
                    //if(array[j]<array[j+1]) this is only change needed for descending bubble sort
                    //is > current j if so swap them if not just move on
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }*/

        //selection sort
        for(int i = 0; i < n - 1; i++) {//the 0  to n - 1 loop
            int minIdx = i;//set the current i as min. index we consider this ith element as minimum
            for(int j = i + 1; j < n; j++) {//then from i+1 to n we see if jth element is < the minIdx if so then jth is
                //reassigned to minIdx as the new one, and we go on looking for the smallest element in unsorted part from i+1 to end
                if(array[j] < array[minIdx]) {
                    //to get descending part just use array[j] > array[j+1] that's it
                    minIdx = j;
                }
            }
            //after that we have temp to minIdx from previous for loop
            int temp = array[minIdx];//and do swap with the current i if any
            array[minIdx] = array[i];
            array[i] = temp;
            // current i th element considered as minIdx, i+1 to n if any element is < minIdx then new minIdx is that otherwise go to next one up to n
            //after coming out of the unsorted part's iteration loop with the min element from it we swap i which naturally bigger than it with that min element
            //effectively placing the i(<minIdx from unsorted part) in its correct position
        }

        //insertion sort
        /*for(int i=1; i<n; i++){//starts from 2nd element to last and is unsorted portion
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
        }*/
        System.out.println(Arrays.toString(array));
    }
}
