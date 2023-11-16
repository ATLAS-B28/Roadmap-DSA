package linkedlist;

class ListNode4{
    int val;
    ListNode4 next;
    ListNode4(int val){
        this.val = val;
    }
}
public class Intersection {
    public static ListNode4 getIntersectionNode(ListNode4 headA,ListNode4 headB){

        ListNode4 currA = headA;

        ListNode4 currB = headB;

        while(currA != currB){

            currA = (currA == null) ? headB : currA.next;

            currB = (currB == null) ? headA : currB.next;
        }

        return currA;
    }

    public static void main(String[] args){

        ListNode4 headA = new ListNode4(3);

        ListNode4 node1 = new ListNode4(7);

        ListNode4 node2 = new ListNode4(8);

        ListNode4 node3 = new ListNode4(10);

        headA.next = node1;

        node1.next = node2;

        node2.next = node3;

        // Create the second linked list: 99 -> 1 -> 8 -> 10

        ListNode4 headB = new ListNode4(99);

        ListNode4 node4 = new ListNode4(1);

        headB.next = node4;

        node4.next = node1;

        ListNode4 intersectionNode = getIntersectionNode(headA,headB);

        if(intersectionNode != null){

            System.out.println(intersectionNode.val);
        }else{

            System.out.println("No intersection found");
        }
    }
}
