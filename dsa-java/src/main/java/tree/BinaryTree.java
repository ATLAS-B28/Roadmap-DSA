package tree;
/*
* For operations like insert, delete and search
* the return type of the function is must be the data type the
* particular data structure has like here Node is the data type of
* the tree so Node will be the return type
* */


class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
//we use recursive functions
public class BinaryTree {
    public Node root;

    public void insert(int data){
        root = insertRecursively(root, data);
    }
    private Node insertRecursively(Node current, int data){
        if(current == null){
            return new Node(data);
        }
        if(data < current.data){
            current.left = insertRecursively(current.left,data);
        }else if(data > current.data){
            current.right = insertRecursively(current.right,data);
        }
        return current;
    }
    public boolean search(int data){
        return searchRecursively(root, data);
    }
    private boolean searchRecursively(Node current, int data){
        if(current == null){
            return false;
        }
        if(data == current.data){
            return true;
        }
        if(data<current.data){
            return searchRecursively(current.left,data);
        }else{
            return searchRecursively(current.right,data);
        }
    }
    public void delete(int data){
        root = deleteRecursively(root, data);
    }
    private Node deleteRecursively(Node current,int data){
        if(current == null){
            return null;
        }
        if(data == current.data){
            //no child node is deleted
            if(current.left == null && current.right == null){
                return null;
            }
            //node has one child
            if(current.left == null){
                return current.right;
            }
            if(current.right == null){
                return current.left;
            }
            //node has 2 child nodes
            int samllestValue = findSmallestValue(current.right);
            current.data = samllestValue;
            current.right = deleteRecursively(current.right,samllestValue);
            return current;
        }
        if(data < current.data){
            current.left = deleteRecursively(current.left,data);
            return current;
        }
        current.right = deleteRecursively(current.right,data);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }
    public void print(){
        printRecursively(root);
    }
    private void printRecursively(Node current){
        if(current == null){
            return;
        }
        printRecursively(current.left);
        System.out.println(current.data+" ");
        printRecursively(current.right);
    }
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(18);
        tree.print();
        System.out.println(tree.search(10));
        tree.delete(10);
        tree.print();
        System.out.println(tree.search(10));
        //System.out.println(tree.search(20));
    }
}

///all traversals