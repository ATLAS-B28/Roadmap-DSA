package tree;
class Node1{
    int data;
    Node1 left;
    Node1 right;
    Node1(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BST {
    private Node1 root;
    public void insert(int data){
        root = insertRecursively(root, data);
    }
    private Node1 insertRecursively(Node1 current,int data){
        if(current == null){
            return new Node1(data);
        }
        if(data < current.data){
            current.left = insertRecursively(current.left,data);
        }else{
            current.right = insertRecursively(current.right,data);
        }
        return current;
    }
    public boolean search(int data){
        return searchRecursively(root,data);
    }
    private boolean searchRecursively(Node1 current,int data){
        if(current == null){
            return false;
        }
        if(data == current.data){
            return true;
        }else if(data < current.data){
            return searchRecursively(current.left,data);
        }else{
            return searchRecursively(current.right,data);
        }
    }
    public void printInOrder(){
        printInOrderRecursively(root);
    }
    private void printInOrderRecursively(Node1 current){
        if(current == null){
            return;
        }
        printInOrderRecursively(current.left);
        System.out.println(current.data + " ");
        printInOrderRecursively(current.right);
    }

    public static void main(String[] args){
        BST tree = new BST();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(18);
        tree.printInOrder();
    }
}
