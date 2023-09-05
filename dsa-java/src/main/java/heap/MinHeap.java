package heap;
import java.util.PriorityQueue;
import java.util.Comparator;
public class MinHeap {
    public static void main(String[] args){
        //PriorityQueue<Integer> minHeap = new PriorityQueue<>();<- min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());//<- max heap
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(30);
        System.out.println(minHeap);
        System.out.println(minHeap.peek());
    }
}
