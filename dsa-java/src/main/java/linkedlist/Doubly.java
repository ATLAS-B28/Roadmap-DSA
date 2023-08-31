package linkedlist;
//doubly ll with hashtable
import java.util.HashMap;
import java.util.Map;
class ListNode{
    int value;
    ListNode prev;
    ListNode next;
    public ListNode(int value){
        this.value = value;
    }
}
public class Doubly{
    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> map;
    public Doubly(){
         head = null;
         tail = null;
        map = new HashMap<>();
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void insert(int key,int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            newNode.prev = tail;
            tail.next = newNode;
            tail =  newNode;
        }
        map.put(key, newNode);
    }
    public void delete(int key){
        ListNode node = map.get(key);
        if(node == null){
            throw new IllegalArgumentException("Key not found");
        }
        if(node == head && node == tail){
            head= null;
            tail = null;
        }
        else if(node == head){
            head = head.next;
            head.prev = null;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        }else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        map.remove(key);
    }
    public boolean containKey(int key){
        return map.containsKey(key);
    }
    public int get(int key){
        return map.get(key).value;
    }
    public void printForward(){
        ListNode current = head;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println();
    }
    public void printBackward(){
        ListNode current = tail;
        while(current != null){
            System.out.println(current.value);
            current = current.prev;
        }
        System.out.println();
    }
    public static void main(String[] args){
        Doubly ll = new Doubly();
        ll.insert(1,1);
        ll.insert(2,2);
        ll.insert(3,3);
        ll.insert(4,4);
        ll.insert(5,5);
        ll.printForward();
        ll.printBackward();
        int i = ll.get(3);
        System.out.println(i);
    }
}