package hashtable;

import java.util.NoSuchElementException;

class KV{
    private final Object key;
    private Object value;
    public KV(Object key,Object value){
        this.key = key;
        this.value = value;
    }
    public Object getKey(){
        return key;//computed with hash
    }
    public Object getValue(){
        return value;//inserted and we use setter and getter
    }
    public void setvalue(Object value){
        this.value = value;
    }
}
public class ArrayHash {
    private final int size;
    private final KV[] table;
    public ArrayHash(int size){
        this.size = size;
        this.table = new KV[size];
    }
    public int HF(Object key){
        return Math.abs(key.hashCode()) % size;
    }
    public void insert(Object key, Object value){
        int index = HF(key);
        KV pair = new KV(key,value);
        if(table[index] == null){
            table[index] = pair;
        }else{
            //collopse
            int newIndex = (index+1)%size;
            while(table[newIndex] != null && newIndex != index){
                newIndex = (newIndex+1)%size;
            }
            if(table[newIndex] == null){
                table[index] = pair;
            }else{
                throw new IllegalStateException("Hash table is full");
            }
        }
    }
    public void get(Object key){
        int index = HF(key);
        if(table[index] != null && table[index].getKey().equals(key)){
            System.out.println(table[index].getKey()+"->"+table[index].getValue());
        }else{
            int newIndex = (index+1)%size;
            while(table[newIndex] != null && !table[newIndex].getKey().equals(key)){
                newIndex = (newIndex+1)%size;
            }
            if(table[newIndex] != null && table[newIndex].getKey().equals(key)){
                System.out.println(table[index].getKey()+"->"+table[index].getValue());
            }else{
                throw new NoSuchElementException("Key not found");
            }
        }
    }
    public void delete(Object key){
        int index = HF(key);
        if(table[index] != null && table[index].getKey().equals(key)){
            table[index] = null;
        }else{
            int newIndex  =(index+1)%size;
            while(table[newIndex] != null && table[newIndex].getKey().equals(key)){
                newIndex = (newIndex+1)%size;
            }
            if(table[newIndex] != null && table[newIndex].getKey().equals(key)){
                table[newIndex] = null;
            }
        }
    }
    public void print(){
        for(int i = 0;i<size;i++){
            KV pair = table[i];
            if(pair != null){
                System.out.println(pair.getKey()+" : "+pair.getValue());
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        ArrayHash hash = new ArrayHash(10);

        hash.insert(1,1);
        hash.insert(2,2);
        hash.insert(3,3);
        hash.print();
        hash.insert(4,4);
        hash.insert(5,5);
        hash.insert(3,6);
        hash.print();
        hash.delete(2);
        hash.get(3);
        hash.print();
    }


}
