package linkedlist;

import java.util.Stack;

class Node2{
    int data;
    Node2 next;
    public Node2(int data){
        this.data = data;
        this.next = null;
    }
}
class LImplement {
    Node2 head;
    Stack<Node2> stack;
    public LImplement(){
        this.head = null;
        this.stack = new Stack<>();
    }
    public void insert(int data){
        Node2 newNode = new Node2(data);
        if(head == null){
            head = newNode;
        }else{
            Node2 current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        stack.push(newNode);
    }
    public void delete(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node2 current = head;
        Node2 prev = null;
        while(current.next != null){
            prev = current;
            current = current.next;
        }
        if(prev != null){
            prev.next = null;
        }else{
            head = null;
        }
        stack.pop();
    }
    public void print(){
        Node2 current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println();
    }
    public void printStack(){
        for(Node2 node: stack){
            System.out.println(node.data+" ");
        }
        System.out.println();
    }
    public int peek(){
        return stack.peek().data;
    }

}

public class LLstack{
    public static void main(String[] args){
        LImplement list = new LImplement();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.print();
        System.out.println("Top element- "+list.peek());
        list.delete();
        list.print();
        list.printStack();
        System.out.println("Top element- "+list.peek());
    }
}
