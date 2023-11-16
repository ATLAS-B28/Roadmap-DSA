package Sorting;
import java.util.Arrays;
//heap, merge, quick
//heap sort -> build max heap
/*public class HQM {
    public void sort(int[] array_string){
        int n = array_string.length;
        //build the max heap
        for(int i = n/2 - 1; i>=0;i--){
            heapify(array_string,n,i);
        }
        //extract from heap one by one
        for(int i=n-1; i>0 ;i--){
            swap(array_string,0,i);
            heapify(array_string,i,0);
        }
    }
    private void heapify(int[] array_string,int n,int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < n && array_string[left] > array_string[largest]){
            largest = left;
        }
        if(right < n && array_string[right] > array_string[largest]){
            largest = right;
        }
        if(largest != i){
            swap(array_string,i,largest);
            heapify(array_string,n,largest);
        }
    }
    private void swap(int[] array_string,int i,int j){
        int temp = array_string[i];
        array_string[i] = array_string[j];
        array_string[j] = temp;
    }
    public static void main(String[] args) {
          HQM hqm = new HQM();
          int[] array_string = {5,2,8,1,9,3,7,4,6};
          hqm.sort(array_string);
          System.out.println(Arrays.toString(array_string));
    }
}*/
/*
///quick sort ->
public class HQM {
    public void sort(int[] array_string){
        QS(array_string,0,array_string.length-1);
    }
    private void QS(int[] array_string,int low, int high){
        if(low < high){
            int pivotIndex = partition(array_string,low,high);
            QS(array_string,low,pivotIndex-1);//i = -1 and j = 0
            QS(array_string,pivotIndex+1,high);//i = pivotIndex and j = pivotIndex + 1
        }
    }
    private int partition(int[] array_string,int low,int high){
        int pivot = array_string[high];
        int i = low -1;
        for(int j = low; j < high;j++){
            if(array_string[j]<pivot){
                i++;
                int temp = array_string[i];
                array_string[i] = array_string[j];
                array_string[j] = temp;
            }
        }
        int temp = array_string[i+1];
        array_string[i+1] = array_string[high];
        array_string[high] = temp;
        return i+1;
    }
    public static void main(String[] args){
        int [] array_string = {5,2,8,1,9,3,7,4,6};
        HQM qs = new HQM();
        qs.sort(array_string);
        System.out.println(Arrays.toString(array_string));
    }
}*/

public class HQM{
    public void sort(int[] array){
        if(array == null || array.length <= 1){
            return;
        }
        MS(array,0,array.length-1);
    }
    private void MS(int[] array,int low, int high){
        if(low<high){
            int mid = low + (high-low)/2;
            MS(array,low,mid);
            MS(array,mid+1,high);
            merge(array,low,mid,high);
        }
    }
    private void merge(int[] array,int low,int mid,int high){
        int leftSize = mid - low + 1;
        int rightSize = high - mid;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        for(int i =0; i < leftSize; i++){
            leftArray[i] = array[low+i];
        }
        for(int j = 0; j < rightSize; j++){
            rightArray[j] = array[mid+j+1];
        }
        int i=0, j=0, k=low;
        while(i<leftSize && j<rightSize){
            if(leftArray[i]<=rightArray[j]){
                array[k]=leftArray[i];
                i++;
            }else{
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i<leftSize){
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while(j<rightSize){
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args){
        HQM ms = new HQM();
        int[] array = {5,2,8,1,9,3,7,4,6};
        ms.sort(array);
        System.out.println(Arrays.toString(array));
    }
}