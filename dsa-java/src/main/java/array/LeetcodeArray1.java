package array;

import java.util.*;

class Solution{
    public int[] intersection(int[] num1,int[] num2){
        HashSet<Integer> set1  =new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int n : num1){
            set1.add(n);
        }
        for(int n : num2){
            //we want intersection
            //i.e. common elements from both the arrays
            if(set1.contains(n)){
                set2.add(n);
            }
        }
        int[] result = new int[set2.size()];
        int index = 0;
        for(int n : set2){
            result[index++] = n;
        }
        return result;
    }
}
public class LeetcodeArray1 {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] num1 = {1,2,2,1,4};
        int[] num2 = {2,2,4};
        int[] result = s.intersection(num1,num2);
        System.out.println(Arrays.toString(result));
    }
}
