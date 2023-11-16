package array_string.StringOps;
import java.util.*;
class TrieNode{
    Map<Character,TrieNode> child;
    boolean isEndOfWord;
    TrieNode(){
        child = new HashMap<>();
        isEndOfWord = false;
    }
}
public class Trie{
    private final TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode current = root;
        for(char c : word.toCharArray()){
            current.child.putIfAbsent(c,new TrieNode());
            //putIfAbsent - inserts a key-value pair for given key and value
            //if key is not present,then insert it
            //else key is there in the map already, it does not change anything
            //and returns the existing value
            current = current.child.get(c);// move to next node in the Trie
        }
        current.isEndOfWord = true;
    }
    public boolean search(String word){
        TrieNode current = root;
        for(char c : word.toCharArray()){
            if(!current.child.containsKey(c)){
                return false; //prefix doesn't exist return false
            }
            current = current.child.get(c);
        }
        return current.isEndOfWord;
    }
    public boolean startsWith(String prefix){
        return deleteBool(root,prefix,0);
    }
    private boolean deleteBool(TrieNode current,String word,int index){
        if(index == word.length()){
            if(!current.isEndOfWord) {
                return false;//word doesn't exit in the trie
            }
            current.isEndOfWord = false;
            return current.child.isEmpty();//if there is no child
        }
        char ch = word.charAt(index);
        if(!current.child.containsKey(ch)){
            return false;//word prefix doesn't exist in the trie
        }
        TrieNode next = current.child.get(ch);
        boolean shouldChildDelete = deleteBool(next,word,index+1);
        if(shouldChildDelete){
            current.child.remove(ch);
            return current.child.isEmpty() && !current.isEndOfWord;
        }
        return false;
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Aditya");
        trie.insert("Add");
        System.out.println(trie.search("Aditya"));
        System.out.println(trie.search("Add"));
        System.out.println(trie.startsWith("Aditya"));
        System.out.println(trie.startsWith("Add"));
        trie.insert("Aditya");
        System.out.println(trie.search("Aditya"));
        System.out.println(trie.startsWith("Aditya"));
    }
}