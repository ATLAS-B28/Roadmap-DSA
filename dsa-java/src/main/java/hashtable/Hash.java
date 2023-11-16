//this is not good implementation
package hashtable;
import java.util.ArrayList;
import java.util.List;
//this is hashmap and uses separate chaining to handle collision
public class Hash {
    private final int size;
    private final List<KV2>[] table;
    public Hash(int size){
        this.size  =size;
        this.table = new ArrayList[size];
    }
    public int HF(Object key){
        return Math.abs(key.hashCode()) % size;
    } 
    public void put(int key,int value){
        int index = HF(key);
        table[index] = table[index] != null ? table[index] : new ArrayList<>();
        table[index].add(new KV2(key,value));
    }
    public void get(int key) {
        int index = HF(key);
        if (table[index] != null) {
            for (KV2 pair : table[index]) {
                if (pair.getKey().equals(key)) {
                    System.out.println(pair.getKey() + "->" + pair.getValue());
                }
            }
        }
    }
    public void delete(int key){
        int index = HF(key);
        if(table[index]!=null){
            List<KV2> pairs = table[index];
            pairs.removeIf(pair -> pair.getKey().equals(key));
        }
    }
    public void print(){
        for(int i = 0; i<size; i++){
            if(table[i]!=null){
                for(KV2 pair: table[i]){
                    System.out.println(pair.getKey()+"->"+pair.getValue());
		}
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        Hash hash = new Hash(10);
        hash.put(1,1);
        hash.put(2,2);
        hash.put(3,3);
        hash.put(4,4);
        hash.put(5,5);
        hash.put(3,6);
        hash.put(6,3);
        hash.put(6,7);
        hash.put(6,4);
        hash.print();
        hash.delete(2);
        hash.print();
        hash.get(3);
        hash.get(6);
    }
}
