package queue;

public class PriorityQueue{
    private int Max;
    private int[] intArr;
    private int itemCount;
    public PriorityQueue(int size){
        Max = size;
        intArr = new int[Max];
        itemCount = 0;
    }
    public void insert(int data){
        int i = 0;
        if(!isFull()){
            if(itemCount == 0) {
                intArr[itemCount++] = data;
            }else{
                for(i = itemCount-1; i>=0; i--){
                    if(data > intArr[i]){
                        intArr[i+1] = intArr[i];
                    }else{
                        break;
                    }
                }
                intArr[i+1] = data;
                itemCount++;
            }
        }
    }
    public void remove(){
        --itemCount;
    }
    public int peek(){
        return intArr[itemCount-1];
    }
    public boolean isEmpty(){
        return itemCount == 0;
    }
    public boolean isFull(){
        return itemCount == Max;
    }
    public int size(){
        return itemCount;
    }
    public void print(){
        for(int i = 0; i < itemCount; i++){
            System.out.println(intArr[i]);
        }
    }
    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert(10);
        pq.insert(20);
        pq.insert(30);
        pq.insert(40);
       // pq.print();
        //System.out.println(pq.peek());
        pq.remove();
        pq.print();
        System.out.println(pq.isEmpty());
    }
}