package queue;

//array_string implementation
public class QueueExample {
    private final int[] queue;
    private int front;
    private int rear;
    private int size;
    public QueueExample(int capacity){
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    public void enqueue(int data){
        if(isFull()){
            throw  new IllegalStateException("Queue is full");
        }
        rear = (rear+1) % queue.length;
        queue[rear] = data;
        size++;
    }
    public void dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        int dequeueValue = queue[front];
        front = (front + 1) % queue.length;
        size--;
    }
    public void peek(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == queue.length;
    }
    public int size(){
        return size;
    }
    public void print(){
        for(int i = front; i < size; i++){
            System.out.println("Element - "+queue[i]);
        }
    }
    public static void main(String[] args){
        QueueExample queue = new QueueExample(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.print();
        System.out.println("Size"+queue.size());
        queue.dequeue();
        queue.print();
        //not printing the 4th element after dequeuing
        System.out.println("Size"+queue.size());
        queue.peek();
    }
}

/*
//linked list implementation
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }

}
public class QueueExample {
    private Node front;
    private Node rear;
    public QueueExample(){
        front = null;
        rear = null;
    }
    public void enqueue(int data){
        Node newNode = new Node(data);
        if(front == null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
    }
    public void dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        int dequeueValue = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        System.out.println("Element removed - "+dequeueValue);
    }
    public void peek(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        System.out.println("Element - "+front.data);
    }
    public boolean isEmpty(){
        return front == null;
    }
    public boolean isFull(){
        return false;
    }
    public int size(){
        int count = 0;
        Node current = front;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    public void print(){
        Node current = front;
        while(current != null){
            System.out.println("Element - "+current.data);
            current = current.next;
        }
    }
    public static void main(String[] args){
        QueueExample queue = new QueueExample();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.print();
        System.out.println("Size - "+queue.size());
        queue.dequeue();
        queue.print();
        System.out.println("Size - "+queue.size());
        queue.peek();
    }
}
*/
