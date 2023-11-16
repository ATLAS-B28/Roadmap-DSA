package array_string;
import java.util.*;
class Solution2{
    public int[] intersect(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0,j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;//if nums1 is smaller
            }else if(nums1[i] > nums2[j]){
                j++;//if nums2 is smaller
            }else{
                arr.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[arr.size()];
        int k = 0;
        while(k < arr.size()){
            result[k] = arr.get(k);
            k++;
        }
        return result;
    }
}

public class Leetcode2Arrays {
    public static void main(String[] args){
        Solution2 s = new Solution2();
        int[] num1 = {1,2,2,1,4};
        int[] num2 = {2,2,4};
        int[] result = s.intersect(num1,num2);
        System.out.println(Arrays.toString(result));
    }
}
