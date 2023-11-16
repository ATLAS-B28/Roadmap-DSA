package linkedlist;

class ListNode2{
    int val;
    ListNode2 next;

    ListNode2(int val){
        this.val = val;
    }
}
public class Partition {
    public static ListNode2 partition(ListNode2 head, int x){
        //creating 2 dummy nodes to hold smaller and greater/equal values
        ListNode2 smallerHead = new ListNode2(0);
        ListNode2 smallerTail = smallerHead;
        ListNode2 greaterHead = new ListNode2(0);
        ListNode2 greaterTail = greaterHead;
        ListNode2 curr = head;

        while(curr != null){
            if(curr.val < x){
                //appending smaller values to smaller list
                smallerTail.next = curr;
                smallerTail = smallerTail.next;
            }else{
                //appending greater/equal values to greater list
                greaterTail.next = curr;
                greaterTail = greaterTail.next;
            }
            curr = curr.next;
        }
        //combining the smaller and greater lists
        greaterTail.next = null;
        smallerTail.next = greaterHead.next;
        //returning the head of the new partitioned list
        return smallerHead.next;
    }

    public static void main(String[] args){
        ListNode2 node1 = new ListNode2(3);
        ListNode2 node2 = new ListNode2(5);
        ListNode2 node3 = new ListNode2(8);
        ListNode2 node4 = new ListNode2(2);
        ListNode2 node5 = new ListNode2(10);
        ListNode2 node6 = new ListNode2(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        int x = 5;
        ListNode2 partitionedHead = partition(node1, x);

        while(partitionedHead != null){
            System.out.println(partitionedHead.val+" ");
            partitionedHead = partitionedHead.next;
        }
    }
}
