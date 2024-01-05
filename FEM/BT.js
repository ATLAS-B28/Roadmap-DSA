/**
 * @template T
 */

class Node {
    /**
     * @param {T} value
     */

    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

/**
 * @template T
 */
class BT{
    constructor(){
        this.root = null;

    }
    /**
     * @param {T} value
     */
    insert(value) {
        const newNode = new Node(value);

        if(this.root === null){
            this.root = newNode;
        }else{
            this.insertNode(this.root, newNode);
        }
    }

    /**
     * @param {Node<T>} node
     * @param {Node<T>} newNode
     */
    insertNode(node, newNode){
        if(newNode.value < node.value){
            if(node.left === null){
                node.left = newNode;
            }else{
                this.insertNode(node.left,newNode);
            }
        }else{
            if(node.right === null){
                node.right = newNode;
            }else{
                this.insertNode(node.right, newNode);
            }
        }
    }
    /**
     * @param {function(T): void} callback
     */
    inOrderTraversal(callback){
        this.inOrderTraversalNode(this.root,callback);
    }
    /**
     * @param {Node<T>} node
     * @param {function(T): void} callback
     */
    inOrderTraversalNode(node,callback){
         if(node !== null){
            this.inOrderTraversalNode(node.left, callback);
            callback(node.value);
            this.inOrderTraversalNode(node.right, callback);
         }
    }
}

const tree = new BT();
tree.insert(5);
tree.insert(3);
tree.insert(7);
tree.insert(2);
tree.insert(4);
tree.insert(6);
tree.insert(8);

tree.inOrderTraversal((value) => console.log(value));