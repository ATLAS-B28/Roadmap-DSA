class Nuts<T> {
    value: T;
    left: Nuts<T> | null;
    right: Nuts<T> | null;

    constructor(value: T) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BST<T> {
    root: Nuts<T> | null;

    constructor(){
        this.root = null;
    }
    insert(value: T): void {
        const newNode = new Nuts(value);

        if(this.root === null){
            this.root = newNode;
        }else{
            this.insertNuts(this.root, newNode);
        }
    }
    private insertNuts(node: Nuts<T>, newNode: Nuts<T>): void {
        if(newNode.value < node.value){
            if(node.left === null){
                node.left = newNode;
            }else{
                this.insertNuts(node.left, newNode);
            }
        }else{
            if(node.right === null){
                node.right = newNode;
            }else{
                this.insertNuts(node.right, newNode);
            }
        }
    }

    search(value: T): boolean {
        return this.searchNuts(this.root, value);
    }

    private searchNuts(node: Nuts<T> | null,value: T): boolean {
        if(node === null){
            return false;
        }

        if(value < node.value){
            return this.searchNuts(node.left,value);
        }else if(value > node.value){
            return this.searchNuts(node.right,value);
        }else {
            return true;
        }
    }

    inorderTraversal(callback: (value: T) => void): void{
        this.inorderTraversalNuts(this.root, callback);
    }

    private inorderTraversalNuts(node: Nuts<T> | null,callback: (value: T) => void): void{
        if(node !== null){
            this.inorderTraversalNuts(node.left, callback);
            callback(node.value);
            this.inorderTraversalNuts(node.right, callback);
        }
    }
}

const bst = new BST<number>();
bst.insert(5);
bst.insert(3);
bst.insert(7);
bst.insert(2);
bst.insert(4);
bst.insert(6);
bst.insert(8);

console.log(bst.search(3));
console.log(bst.search(9));