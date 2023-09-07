package tree;
// avl tree - balanced tree
class Node2{
    int key;
    int height;
    Node2 left;
    Node2 right;
    public Node2(int key){
        this.key = key;
        this.height = 1;//start from 1
        this.left = null;
        this.right = null;
    }
}
public class AVL {
    private Node2 root;
    private int height(Node2 node){
        if(node == null){
            return 0;
        }
        return node.height;
    }
    private int balanceFactor(Node2 node){
        if(node == null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }
    private Node2 rotateLeft(Node2 z){
        Node2 y = z.right;
        if(y == null){
            // handle the case where z.right is null
            // you can throw an exception, return a default value, or perform any other required action
            // for example, you can return z without performing any rotation
            return z;
        }
        Node2 T2 = y.left;
        y.left = z;
        z.right = T2;
        z.height = Math.max(height(z.left),height(z.right))+1;
        y.height = Math.max(height(y.left),height(y.right))+1;
        return y;
    }
    private Node2 rotateRight(Node2 z){
        Node2 y = z.left;
        if(y == null){
            // handle the case where z.left is null
            // you can throw an exception, return a default value, or perform any other required action
            // for example, you can return z without performing any rotation
            return z;
        }
        Node2 T2 = y.right;
        y.right = z;
        z.left = T2;
        z.height = Math.max(height(z.left),height(z.right))+1;
        y.height = Math.max(height(y.left),height(y.right))+1;
        return y;
    }
    public void insert(int key){
        root = insertNode(root,key);
    }
    private Node2 insertNode(Node2 node,int key){
        if(node == null){
            return new Node2(key);
        }
        if(key < node.key){
            node.left = insertNode(node.left,key);
        }else if(key > node.key){
            node.right = insertNode(node.right,key);
        }else{
            //duplicates not allowed
            return node;
        }
        node.height = 1 + Math.max(height(node.left),height(node.right));
        int balance = balanceFactor(node);
        //left-left
        if(balance > 1 && key < node.left.key){
            return rotateLeft(node);
        }
        //right-right
        if(balance < -1 && key > node.right.key){
            return rotateRight(node);
        }
        //left-right
        if(balance > 1 && key > node.left.key){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        //right-left
        if(balance < -1 && key < node.right.key){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }
    public void delete(int key){
        root = deleteNode(root,key);
    }
    private Node2 deleteNode(Node2 node,int key){
        if(root == null){
            return null;
        }
        if(key < node.key){
            node.left = deleteNode(node.left,key);
        }else if(key > node.key){
            node.right = deleteNode(node.right,key);
        }else{
            //node to be deleted is found
            //case 1 - node has no or one child
            if(node.left == null || node.right == null){
                Node2 child = (node.left != null)? node.left : node.right;
                if(child == null){
                    node = null;
                }else{
                    node = child;
                }
            }//case 2 - node has 2 child
            else{
                Node2 successor = findMin(node.right);
                node.key = successor.key;
                node.right = deleteNode(node.right, successor.key);
            }
        }
        if(node != null){
            node.height = Math.max(height(node.left),height(node.right));
            int balance = balanceFactor(node);
            //perform avl rotations
            if(balance > 1 && balanceFactor(node.left) >=0){
                return rotateRight(node);
            }
            if(balance > 1 && balanceFactor(node.left) < 0){
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
            if(balance < -1 && balanceFactor(node.right) <=0){
                return rotateLeft(node);
            }
            if(balance < -1 && balanceFactor(node.right) > 0){
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }
    private Node2 findMin(Node2 node){
        Node2 current = node;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }
    private void inOrderTraversal(Node2 node){
        if(node != null){
            inOrderTraversal(node.left);
            System.out.println(node.key+" ");
            inOrderTraversal(node.right);
        }
    }
    public void printTree(){
        inOrderTraversal(root);
    }



    public static void main(String[] args){
        AVL avl = new AVL();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);
        avl.insert(60);
        avl.insert(70);
        avl.insert(80);
        avl.insert(90);
        avl.insert(100);
        avl.insert(33);
        avl.insert(44);
        avl.printTree();
        avl.delete(10);
        avl.printTree();
    }
}
