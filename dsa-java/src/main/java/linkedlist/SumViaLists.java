package linkedlist;

class ListNode3{
    int val;
    ListNode3 next;
    ListNode3(int val){
        this.val = val;
    }
}

public class SumViaLists {
    public static ListNode3 add2Numbers(ListNode3 l1,ListNode3 l2){
        ListNode3 dummyHead = new ListNode3(0);
        ListNode3 curr = dummyHead;
        int carry = 0;
        while(l1 != null || l2 != null){

            int sum = carry;

            if(l1 != null){

                sum += l1.val;

                l1 = l1.next;
            }

            if(l2 != null){

                sum += l2.val;

                l2 = l2.next;
            }

            carry = sum/10;

            curr.next = new ListNode3(sum % 10);

            curr = curr.next;
        }
        if(carry > 0){

            curr.next = new ListNode3(carry);
        }
        return dummyHead.next;
    }
    public static void main(String[] args){

        ListNode3 l1 = new ListNode3(7);
        l1.next = new ListNode3(1);
        l1.next.next = new ListNode3(6);

        ListNode3 l2 = new ListNode3(5);
        l2.next = new ListNode3(9);
        l2.next.next = new ListNode3(2);

        ListNode3 result = add2Numbers(l1,l2);

        while(result != null){

            System.out.println(result.val);

            result = result.next;
        }
    }
}
