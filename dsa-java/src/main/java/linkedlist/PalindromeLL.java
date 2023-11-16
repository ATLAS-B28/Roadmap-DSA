package linkedlist;

import java.util.ArrayList;
import java.util.List;
class ListNode5{
    int val;
    ListNode5 next;
    ListNode5(int val){
        this.val = val;
    }
}

public class PalindromeLL {
    public static boolean isPalindrome(ListNode5 head){
        //traverse the LL and store value in an array
        List<Integer> values = new ArrayList<>();
        ListNode5 curr = head;

        while(curr != null){
            values.add(curr.val);
            curr = curr.next;
        }
        //compare elements from beginning and end
        int left = 0;
        int right = values.size() - 1;

        while(left < right){
            if(!values.get(left).equals(values.get(right))){
                return false;
            }
            left++;
            right--;
        }
        //if all match then return true
        return true;
    }
    public static void main(String[] args){
        ListNode5 head = new ListNode5(1);
        ListNode5 node1 = new ListNode5(2);
        ListNode5 node2 = new ListNode5(3);
        ListNode5 node3 = new ListNode5(2);
        ListNode5 node4 = new ListNode5(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome(head));
    }
}
