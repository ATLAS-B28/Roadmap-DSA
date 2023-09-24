package caches;
import java.util.*;
public class LRU {
    private static class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final Map<Integer,Node> cache;
    private final Node head;
    private final Node tail;
    public LRU(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    public int get(int key){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }
    public void put(int key,int value){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            Node newNode = new Node(key, value);
            cache.put(key,newNode);
            addToHead(newNode);
            if(cache.size() > capacity){
                Node tailNode = removeTail();
                cache.remove(tailNode.key);
            }
        }
    }
    private void addToHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private  void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    private Node removeTail(){
        Node tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }
    public static void main(String[] args){
        LRU lru = new LRU(5);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        lru.put(5,5);
        lru.put(6,6);
        lru.put(7,7);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
        System.out.println(lru.get(5));
        System.out.println(lru.get(6));
        System.out.println(lru.get(7));
    }
}
