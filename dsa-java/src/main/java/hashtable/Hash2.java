package hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hash2 {
    private final Map<Integer, List<Integer>> map;
    public Hash2(){
        map = new HashMap<>();
    }
    public void put(int key,int value){
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }
    public void delete(int key, int value){
        if(map.containsKey(key)){
            List<Integer> values = map.get(key);
            values.remove(Integer.valueOf(value));
            if(values.isEmpty()){
                map.remove(key);
            }
        }
    }
    public Integer get(int key,int index){
        List<Integer> values = map.get(key);
        if(values !=null && index >= 0 && index < values.size()){
            System.out.println(values.get(index));
        }
        return null;
    }
    public void print(){
        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet()){
            int key = entry.getKey();
            List<Integer> values = entry.getValue();
            System.out.println(key+"->"+values);
            for(int value: values){
                System.out.println(value+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Hash2 hash = new Hash2();
        hash.put(1,1);
        hash.put(2,2);
        hash.put(3,3);
        hash.put(4,4);
        hash.put(5,5);
        hash.put(5,4);
        hash.print();
        hash.delete(5,4);
        hash.print();
        hash.get(5,0);
        hash.put(5,6);
        hash.print();
        hash.get(5,1);
    }
}
