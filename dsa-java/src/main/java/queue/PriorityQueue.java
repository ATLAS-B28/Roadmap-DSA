package queue;

public class PriorityQueue {
    private int[] queue;
    private int size;
    public PriorityQueue(){
        queue = new int[10];
        size = 0;
    }
    public void offer(int ele){
        if(size == queue.length){
            increaseSize();
        }
        queue[size++] = ele;
        bubbleUp(size-1);
    }
    public void poll(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        int ele = queue[0];
        queue[0] = queue[size-1];
        size--;
        bubbleDown(0);
        System.out.println("Highest Priority Element - "+ele);
    }
    public boolean isEmpty(){
        return size == 0;
    }
    private void bubbleUp(int index){
        int parentIndex = (index-1)/2;
        while(index>0 && queue[index] < queue[parentIndex]){
            swap(index,parentIndex);
            parentIndex = (index-1)/2;
        }
    }
    private void bubbleDown(int index){
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;
        if(leftChildIndex<size && queue[leftChildIndex]<queue[smallestIndex]){
            smallestIndex = leftChildIndex;
        }
        if(rightChildIndex<size && queue[rightChildIndex]<queue[smallestIndex]){
            smallestIndex = rightChildIndex;
        }
        if(smallestIndex != index){
            swap(index,smallestIndex);
            bubbleDown(smallestIndex);
        }
    }
    private void swap(int index1,int index2){
        int temp = queue[index1];
        queue[index1] = queue[index2];
        queue[index2] = temp;
    }
    private void increaseSize(){
        int newCap = queue.length * 2;
        int[] newQueue = new int[newCap];
        System.arraycopy(queue,0,newQueue,0,size);
        queue = newQueue;
    }
    public void print(){
        for(int i = 0;i<size;i++){
            System.out.println(queue[i]);
        }
    }
    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue();
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(4);
        pq.offer(5);
        pq.print();
        System.out.println("After polling");
        pq.poll();
        pq.print();
        System.out.println("After polling");
        pq.poll();
        pq.print();
        System.out.println("Another case:");
        pq.offer(1);
        pq.print();
        System.out.println("Another case:");
        pq.offer(2);
        pq.print();
        System.out.println("After polling");
        pq.poll();
        pq.print();
        pq.poll();
        pq.poll();
        System.out.println("After polling x2");
        pq.print();
    }
}
