package stack;

import java.util.*;
class Node6{
    Node6 above;
    Node6 below;
    int val;
    Node6(int val){
        this.val = val;
    }
}
class Stack1{
    private final int capacity;
    public Node6 top;
    public Node6 bottom;
    public int size = 0;


    public Stack1(int capacity){
        this.capacity = capacity;
    }
    public boolean isFull() {
        return capacity == size;
    }
    public void join(Node6 above,Node6 below){
        if(below != null) below.above = above;
        if(above != null) above.below = below;
    }
    public void push(int val){
        if(size >= capacity) return;
        size++;
        Node6 n = new Node6(val);
        if(size == 1) bottom = n;
        join(n,top);
        top = n;
    }
    public int pop(){
        if(top == null) throw new EmptyStackException();
        Node6 t = top;
        top = top.below;
        size--;
        return t.val;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int removeBottom(){
        Node6 b = bottom;
        bottom = bottom.above;
        if(bottom != null) bottom.below = null;
        size--;
        return b.val;
    }
}
class SetOfStacks{
    ArrayList<Stack1> stacks = new ArrayList<>();
    public int capacity;

    SetOfStacks(int capacity){
        this.capacity = capacity;
    }
    public Stack1 getLastStack(){
        if(stacks.isEmpty()){
            return null;
        }
        return stacks.get(stacks.size()-1);
    }
    public void push(int v){
        Stack1 last = getLastStack();
        if(last != null && !last.isFull()){
            last.push(v);
        }else{
            Stack1 s = new Stack1(capacity);
            s.push(v);
            stacks.add(s);
        }
    }
    public int pop(){
        Stack1 last = getLastStack();
        if(last == null) throw new EmptyStackException();
        int v = last.pop();
        if(last.size == 0){
            stacks.remove(stacks.size()-1);
        }
        return v;
    }
    public int popAt(int index){
        return leftShift(index,true);
    }
    public int leftShift(int index,boolean removeTop){
        if(index < 0 || index >= stacks.size()){
            throw new IndexOutOfBoundsException("Invalid index: "+index);
        }
        Stack1 stack = stacks.get(index);
        int removed_items;
        if(removeTop) removed_items = stack.pop();
        else removed_items = stack.removeBottom();
        if(stack.isEmpty()){
            stacks.remove(index);
        }else if(stacks.size() > index + 1){
            int v = leftShift(index + 1,false);
            stack.push(v);
        }
        return removed_items;
    }
    public boolean isEmpty(){
       Stack1 last = getLastStack();
       return last == null || last.isEmpty();
    }
}
public class StackPlates {
    public static void main(String[] args) {
        int capacity_per_substack = 5;
        SetOfStacks set = new SetOfStacks(capacity_per_substack);
        for(int i = 0; i < 34; i++){
            set.push(i);
        }
        for(int i = 0; i < 35; i++){
            System.out.println("Popped: "+set.popAt(i));
        }
    }
}
