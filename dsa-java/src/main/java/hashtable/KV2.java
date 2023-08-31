package hashtable;

public class KV2 {
    private final Object key;
    private final Object value;
    public KV2(Object key,Object value){
        this.key = key;
        this.value = value;
    }
    public Object getKey(){
        return key;//computed with hash
    }
    public Integer getValue(){
        return (Integer) value;//inserted and we use setter and getter
    }
}
