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
    public void inOrder(){
        IOR(root);
    }
    private void IOR(Node1 current){
        if(current == null){
            return;
        }
        IOR(current.left);
        System.out.println(current.data + " ");
        IOR(current.right);
    }

    public void preOrder(){
        POR(root);
    }
    private void POR(Node1 current){
        if(current == null){
            return;
        }
        System.out.println(current.data+" ");
        POR(current.left);
        POR(current.right);
    }

    public void postOrder(){
        POOR(root);
    }

    private void POOR(Node1 current){
        if(current == null){
            return;
        }
        POOR(current.left);
        POOR(current.right);
        System.out.println(current.data+" ");
    }

    public void delete(int data){
        root = deleteRecursively(root,data);
    }
    private Node1 deleteRecursively(Node1 current, int data){//<-so here we go into right subtree and find leftmost min value
        if(current == null){
            return null;
        }
        if(data < current.data){
            current.left = deleteRecursively(current.left,data);
        }else if(data > current.data){
            current.right = deleteRecursively(current.right,data);
        }else{
            if(current.left == null){
                return current.right;
            }else if(current.right == null){
                return current.left;
            }
            current.data = minValue(current.right);
            current.right = deleteRecursively(current.right,current.data);
        }
        return current;
    }
    private int minValue(Node1 current){
        while(current.left != null){
            current = current.left;
        }
        return current.data;
    }

    public static void main(String[] args){
        BST tree = new BST();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(18);
        System.out.println("Inorder");
        tree.inOrder();
        System.out.println("Preorder");
        tree.preOrder();
        System.out.println("Postorder");
        tree.postOrder();
        tree.delete(15);
        System.out.println("New Inorder");
        tree.inOrder();
        System.out.println("New Preorder");
        tree.preOrder();
        System.out.println("New Postorder");
        tree.postOrder();
    }
}
