package caches;
import java.util.*;
class MFUImplementation<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;
    public MFUImplementation(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > capacity;
    }
}
public class MFU{
    public static void main(String[] args){
        MFUImplementation<Integer,Integer> cache = new MFUImplementation<>(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        System.out.println("MRU contents : ");
        cache.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
