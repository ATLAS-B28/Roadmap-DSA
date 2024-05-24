package heap;

class heapN {
    private int[] heap;
    private int size;

    public heapN() {
        this.heap = new int[2];
        this.size = 0;
    }

    //insert
    public void insert(int val) {
        //resize the heap array
        if(size == heap.length - 1) {
            int[] newHeap = new int[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }

        //add the new element
        heap[size + 1] = val;
        size++;
        // Heapify the heap by bubbling up the new element
        heapifyUp(size);//to maintain heap property
    }

    private void heapifyUp(int id) {
        while(id > 1 && heap[id] > heap[parent(id)]) {
           int maxChildIndex = getMaxChildIndex(id);
           if(heap[id] < heap[maxChildIndex]) {
            swap(id, maxChildIndex);
            id = maxChildIndex;
           } else {
            return;
           }
        }
    }

    public int popMax() {
        if(size == 0) {
            throw new IllegalStateException("heap is empty");
        }
        //get the max. element (root of the heap)
        int max = heap[1];
        //move last element to the root
        heap[1] = heap[max];
        size--;
        heapifyDown(1);
        return max;
    }

    private void heapifyDown(int id) {
        while(hasChildren(id)) {
            int maxChildIndex = getMaxChildIndex(id);
            if(heap[id] < heap[maxChildIndex]) {
                swap(id, maxChildIndex);
                id = maxChildIndex;
            } else {
                return;
            }
        }
    }

    private int parent(int id) {
        return id / 2;
    }

    private int getMaxChildIndex(int id) {
        int maxIndex = id * 2;
        for(int i = 1; i < (1 << (int) (Math.log(size - id + 1)/Math.log(2))); i++) {
            if((id * 2 + i) <= size && heap[id * 2 + i] > heap[maxIndex]) {
                maxIndex = id * 2 + i;
            }
        }
        return maxIndex;
    }

    private boolean hasChildren(int id) {
        return (id * 2) <= size;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}

public class heaptwopown {

    public static void main(String[] args) {
        heapN h = new heapN();
        h.insert(5);
        h.insert(2);
        h.insert(7);
        h.insert(3);
        h.insert(4);
        System.out.println(h.popMax());
    }
}