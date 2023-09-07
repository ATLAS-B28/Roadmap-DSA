package Sorting;

public class Searching {
    //linear search
    public static int LS(int[] array,int target){
        for(int i = 0;i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static int BS(int[] array,int target){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] array = {5,2,8,1,9,3,7,4,6};
        int idx = LS(array,9);
        int[] array2 = {1,2,3,4,5,6,7,8,9};
        int idx2 = BS(array2,9);
        if(idx != 1){
            System.out.println("Target found at index: "+idx2);
        }else{
            System.out.println("Target not found");
        }
    }
}
