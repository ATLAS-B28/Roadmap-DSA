package linkedlist;
class ListNode1{
    int val;
    ListNode1 next;
    ListNode1(int val){
        this.val = val;
    }
}

public class KthLast{
    public static ListNode1 returnKthToLast(ListNode1 head ,int k){
        if(head == null || k <= 0){
            return null;
        }
        ListNode1 slow = head;
        ListNode1 fast = head;
        //move the fast pointer k nodes ahead
        for(int i = 0; i < k; i++){
            if(fast == null){
                return slow;
            }
            fast = fast.next;
        }
        //move both pointers until fast reaches the end
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);
        ListNode1 result = returnKthToLast(head, 2);
        System.out.println("The kth to last element is here 2nd last element : "+result.val);
    }
}