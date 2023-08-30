package stack;

// this is array implementation
/*
class Stack {
    private int size;
    private  int[] stackArray;
    private int top;
    public Stack(int size){
        this.size = size;
        this.stackArray = new int[size];//new array of size n and type int
        this.top = -1;//indicates no elements
    }
    public void push(int data){
        if(isFull()){//write it like this - functionName()
            throw new IllegalStateException("Stack is full");
        }
        stackArray[++top] = data;//pre-increment from -1 to 0 ,0 to 1, 1 to ...n
    }
    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[top--];//post decrement
    }
    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[top];
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == size-1;
    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.println(stackArray[i]);
        }
    }
}

public class StackExample{
    public static void main(String[] args){
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();
        System.out.println(stack.peek());
        stack.pop();
        stack.print();
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
    }
}*/

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class Stack{
    private Node top;
    public Stack(){
        this.top = null;
    }
    public void push(int data){
        Node newNode = new Node(data);
        if (!isEmpty()) {
            newNode.next = top;//the next attribute points to current top element
        }
        top = newNode;//and now the new top is the new node, but its next attribute is still pointing
        //to previous top
    }
    public void pop(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = top.data;
        top = top.next;//
        System.out.println("Popped: "+data);
    }
    public int peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }
    public void print(){
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    public boolean isFull(){
        return false;
    }
    public boolean isEmpty(){
        return top == null;
    }
}
public class StackExample{
    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();
        System.out.println(stack.peek());
        stack.pop();
        stack.print();
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
    }
}