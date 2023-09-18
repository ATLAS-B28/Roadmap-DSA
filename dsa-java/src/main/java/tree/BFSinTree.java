package tree;
import java.util.LinkedList;
import java.util.Queue;

class Node4{
    int data;
    Node4 left;
    Node4 right;
    public Node4(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BFSinTree {
    public static void BFSinTree(Node4 root){
        if(root == null){
            return;
        }
        Queue<Node4> qe = new LinkedList<>();
        qe.add(root);
        while(!qe.isEmpty()){
            Node4 current = qe.poll();
            System.out.println(current.data+" ");
            if(current.left != null){
                qe.add(current.left);
            }
            if(current.right != null){
                qe.add(current.right);
            }
        }
    }
    public static void main(String[] args){
        Node4 root = new Node4(1);
        root.left = new Node4(2);
        root.right = new Node4(4);
        root.left.left = new Node4(5);
        root.left.right = new Node4(6);
        root.right.left = new Node4(7);
        root.right.right = new Node4(8);
        System.out.println("BFS (level-order) traversal: ");
        BFSinTree(root);
    }
}
