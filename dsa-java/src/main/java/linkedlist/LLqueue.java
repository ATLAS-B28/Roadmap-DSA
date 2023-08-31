package linkedlist;
// Problem with this code
import java.util.NoSuchElementException;

class Node3{
    int data;
    Node3 next;
    public Node3(int data){
        this.data = data;
        this.next = null;
    }
}
public class LLqueue {
    private Node3 head;
    private Node3 tail;
    public LLqueue(){
        this.head= null;
        this.tail = null;
    }
    public void enqueue(int data){
        Node3 newNode = new Node3(data);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = head;
            head = newNode;
        }
    }
    public void dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        int data = head.data;
        head = head.next;
        if(head==null){
            tail = null;
        }
        System.out.println("Element removed - "+data);
    }
    public boolean isEmpty(){
        return head == null;
    }
    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }
    public void print(){
        Node3 current = head;
        while(current != null){
            System.out.println("Element - "+current.data);
            current = current.next;
        }
        System.out.println();
    }
    public int size(){
        int count = 0;
        Node3 current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        System.out.println("Size - "+count);
        return count;
    }
    public static void main(String[] args){
        LLqueue queue = new LLqueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.print();
        queue.peek();
        System.out.println("Size - "+queue.size());
        queue.dequeue();
        queue.print();
    }
}
