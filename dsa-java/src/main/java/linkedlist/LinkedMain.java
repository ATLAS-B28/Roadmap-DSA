package linkedlist;

import java.util.NoSuchElementException;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList {
    Node head;
    public LinkedList(){
        this.head = null;
    }
    public void insert(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;//
                /*
                * node1->node2->node3->null
                * so till node3 ,after this
                * current is updated to point
                * to next node with current.next which is now null
                * here we come out of loop with
                * current having last node's reference
                * and assign the newNode to it
                * */
            }
            current.next = newNode;
        }

    }
    public void delete(int data){
        if(head ==null){
            return;
        }
        if(head.data == data){
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next != null){
            if(current.next.data ==data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public boolean search(int data){
        Node current = head;
        while(current != null){
            if(current.data == data){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int peek(){
        if(head==null){
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }
    public void print(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}
public class LinkedMain{
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.print();
        System.out.println("peek "+list.peek());
        System.out.println("search "+list.search(4));
        list.print();
        list.delete(3);
        list.print();
    }
}

