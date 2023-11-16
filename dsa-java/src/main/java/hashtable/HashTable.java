package hashtable;
//open addressing 
public class HashTable {
    private static class Entry{
        private final int key;
        private final int value;

        public Entry(int key,int value){
            this.key = key;
            this.value = value;
        }

        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
    }

    private final int size;
    private final Entry[] table;

    public HashTable(int size){
        this.size = size;
        this.table = new Entry[size];
    }

    private int hashFunction(int key){
        return key % size;
    }
    public void put(int key,int value){
        int index = hashFunction(key);
        Entry entry = new Entry(key,value);
        int count = 0;

        while (table[index] != null && table[index].getKey() != key) {
            index = (index + 1)%size;
            count++;
        }
        if(count == size){
            throw new IllegalStateException("Hash table is full");
        }
        table[index] = entry;
    }

    public int get(int key){
        int index = hashFunction(key);

        while(table[index] != null && table[index].getKey() != key){
            index = (index + 1)%size;
        }

        if(table[index] != null){
            return table[index].getValue();
        }
        return -1;
    }

    public void delete(int key){
        int index = hashFunction(key);

        while(table[index] != null && table[index].getKey() != key){
            index = (index + 1)%size;
        }

        if(table[index] != null){
           table[index] = null;  
        }
    }

    public static void main(String[] args){
        HashTable hashTable = new HashTable(5);
        hashTable.put(1, 1);
        hashTable.put(2, 2);
        hashTable.put(3, 3);
        hashTable.put(4, 4);
        hashTable.put(5, 5);
        hashTable.put(6, 6);

        System.out.println(hashTable.get(1));
        System.out.println(hashTable.get(6)); 

        hashTable.delete(3);

        System.out.println(hashTable.get(3));


   
    }

   
}
