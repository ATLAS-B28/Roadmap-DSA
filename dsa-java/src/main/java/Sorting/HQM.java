package Sorting;
import java.util.Arrays;
//heap, merge, quick
//heap sort -> build max heap
/*public class HQM {
    public void sort(int[] array){
        int n = array.length;
        //build the max heap
        for(int i = n/2 - 1; i>=0;i--){
            heapify(array,n,i);
        }
        //extract from heap one by one
        for(int i=n-1; i>0 ;i--){
            swap(array,0,i);
            heapify(array,i,0);
        }
    }
    private void heapify(int[] array,int n,int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < n && array[left] > array[largest]){
            largest = left;
        }
        if(right < n && array[right] > array[largest]){
            largest = right;
        }
        if(largest != i){
            swap(array,i,largest);
            heapify(array,n,largest);
        }
    }
    private void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
          HQM hqm = new HQM();
          int[] array = {5,2,8,1,9,3,7,4,6};
          hqm.sort(array);
          System.out.println(Arrays.toString(array));
    }
}*/

///quick sort ->
/*public class HQM {
    public void sort(int[] array){
        QS(array,0,array.length-1);
    }
    private void QS(int[] array,int low, int high){
        if(low < high){
            int pivotIndex = partition(array,low,high);
            QS(array,low,pivotIndex-1);
            QS(array,pivotIndex+1,high);
        }
    }
    private int partition(int[] array,int low,int high){
        int pivot = array[high];
        int i = low -1;
        for(int j = low; j < high;j++){
            if(array[j]<pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }
    public static void main(String[] args){
        int [] array = {5,2,8,1,9,3,7,4,6};
        HQM qs = new HQM();
        qs.sort(array);
        System.out.println(Arrays.toString(array));
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
