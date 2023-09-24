package caches;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;
/*
Hash table and linked list implementation of the Set interface,
with predictable iteration order. This implementation differs from
HashSet in that it maintains a doubly-linked list running through
all of its entries. This linked list defines the iteration ordering,
which is the order in which elements were inserted
into the set (insertion-order).
* */
public class LFU {
    private final Map<Integer,Integer> keyToValue;
    private final Map<Integer,Integer> keyToFrequency;
    private final Map<Integer,LinkedHashSet<Integer>> frequencyToKeys;
    private final int capacity;
    private int minFrequency;
    public LFU(int capacity){
        this.keyToValue = new HashMap<>();
        this.keyToFrequency = new HashMap<>();
        this.frequencyToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minFrequency = 0;
    }
    public int get(int key){
        if(keyToValue.containsKey(key)){
            increaseFrequency(key);
            return keyToValue.get(key);
        }
        return -1;
    }
    public void put(int key,int value){
        if(capacity <= 0){
            return;
        }
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key,value);
            increaseFrequency(key);
        }else{
            if(keyToValue.size()>= capacity){
                removeLFU();
            }
            keyToValue.put(key,value);
            keyToFrequency.put(key,1);
            frequencyToKeys.computeIfAbsent(1,k -> new LinkedHashSet<>()).add(key);
            minFrequency = 1;
        }
    }
    private void increaseFrequency(int key){
        int freq = keyToFrequency.get(key);
        keyToFrequency.put(key,freq+1);
        frequencyToKeys.get(freq).remove(key);
        frequencyToKeys.computeIfAbsent(freq+1,k -> new LinkedHashSet<>()).add(key);
        if(frequencyToKeys.get(freq).isEmpty()){
            frequencyToKeys.remove(freq);
            if(freq == minFrequency){
                minFrequency++;
            }
        }
    }
    private void removeLFU(){
        LinkedHashSet<Integer> keys = frequencyToKeys.get(minFrequency);
        int keyToRemove = keys.iterator().next();
        keys.remove(keyToRemove);
        keyToValue.remove(keyToRemove);
    }
    public static void main(String[] args){
        LFU lfu = new LFU(5);
        lfu.put(1,1);
        lfu.put(2,2);
        System.out.println(lfu.get(1));
        lfu.put(3,3);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(4,4);
        lfu.put(5,6);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(4));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(5));
    }
}
