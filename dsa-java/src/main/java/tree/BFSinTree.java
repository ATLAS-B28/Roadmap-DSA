package tree;
import java.util.*;
//implement bfs traversal to find a particular element
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
    public static void BFSTree(Node4 root){
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
    public static Node4 insert(Node4 root,int data){
        if(root == null){
            return new Node4(data);
        }else{
            if(data < root.data){
                root.left = insert(root.left,data);
            }else{
                root.right = insert(root.right,data);
            }
            return root;
        }
    }
    public static List<Integer> findElement(Node4 root,int target){
        if(root == null){
            return null;
        }
        Queue<Node4> nodeQueue = new LinkedList<>();
        Queue<List<Integer>> pathQueue = new LinkedList<>();
        nodeQueue.add(root);
        pathQueue.add(Collections.singletonList(root.data));
        while(!nodeQueue.isEmpty()){
            Node4 current = nodeQueue.poll();
            List<Integer> currentPath = pathQueue.poll();
            if(current.data == target){
                return currentPath;
            }
            if(current.left != null){
                assert currentPath != null;
                List<Integer> leftPath = new ArrayList<>(currentPath);
                leftPath.add(current.left.data);
                nodeQueue.add(current.left);
                pathQueue.add(leftPath);
            }
            if(current.right != null){
                assert currentPath != null;
                List<Integer> rightPath = new ArrayList<>(currentPath);
                rightPath.add(current.right.data );
                nodeQueue.add(current.right);
                pathQueue.add(rightPath);
            }
        }
        return null;
    }
    public static void main(String[] args){
        Node4 root = null;
        root = insert(root, 1);
        insert(root, 2);
        insert(root, 3);
        insert(root, 4);
        insert(root, 5);
        insert(root, 6);
        insert(root, 7);
        insert(root, 8);
        System.out.println("BFS (level-order) traversal: ");
        BFSTree(root);
        int target = 3;
        List<Integer> path = findElement(root,target);
        if(path!=null){
            System.out.println("Path from root to "+target);
            for(int i = 0;i < path.size();i++){
                System.out.print(path.get(i)+" ");
                if(i < path.size()-1){
                    System.out.println("->");
                }
            }
        }else{
            System.out.println("Element not path found");
        }
    }
}
