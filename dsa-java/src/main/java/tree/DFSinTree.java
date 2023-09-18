package tree;
class Node3{
    int data;
    Node3 left;
    Node3 right;
    public Node3(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class DFSinTree {
    private Node3 root;
    public void insert(int data){
        root = insertRecursively(root, data);
    }
    private Node3 insertRecursively(Node3 current,int data){
        if(current == null){
            return new Node3(data);
        }
        if(data < current.data){
            current.left = insertRecursively(current.left,data);
        }else{
            current.right = insertRecursively(current.right,data);
        }
        return current;
    }
    public void search(int data){
        searchRecursively(root, data);
    }
    private boolean searchRecursively(Node3 current,int data){
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
    public void printInOrderDFS(){
        inOrderDFS(root);
    }
    private void inOrderDFS(Node3 current){
        if(current == null){
            return;
        }
        inOrderDFS(current.left);
        System.out.println(current.data + " ");
        inOrderDFS(current.right);
    }

    public void printPreOderDFS(){
        preOrderDFS(root);
    }
    private void preOrderDFS(Node3 current){
        if(current == null){
            return;
        }
        System.out.println(current.data+" ");
        preOrderDFS(current.left);
        preOrderDFS(current.right);
    }

    public void printPostOrderDFS(){
        postOrderDFS(root);
    }

    private void postOrderDFS(Node3 current){
        if(current == null){
            return;
        }
        postOrderDFS(current.left);
        postOrderDFS(current.right);
        System.out.println(current.data+" ");
    }

    public void delete(int data){
        root = deleteRecursively(root,data);
    }
    private Node3 deleteRecursively(Node3 current, int data){//<-so here we go into right subtree and find leftmost min value
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
    private int minValue(Node3 current){
        int minVal  = current.data;
        while(current.left != null){
            minVal = current.left.data;
            current = current.left;
        }
        return minVal;
    }

    public static void main(String[] args){
        DFSinTree tree = new DFSinTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(18);
        tree.search(15);
        System.out.println("DFS Inorder");
        tree.printInOrderDFS();
        System.out.println("DFS Preorder");
        tree.printPreOderDFS();
        System.out.println("DFS Postorder");
        tree.printPostOrderDFS();
        tree.delete(15);
        System.out.println("New DFS Inorder");
        tree.printInOrderDFS();
        System.out.println("New DFS Preorder");
        tree.printPreOderDFS();
        System.out.println("New DFS Postorder");
        tree.printPostOrderDFS();
    }
}

