var Nuts = /** @class */ (function () {
    function Nuts(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    return Nuts;
}());
var BST = /** @class */ (function () {
    function BST() {
        this.root = null;
    }
    BST.prototype.insert = function (value) {
        var newNode = new Nuts(value);
        if (this.root === null) {
            this.root = newNode;
        }
        else {
            this.insertNuts(this.root, newNode);
        }
    };
    BST.prototype.insertNuts = function (node, newNode) {
        if (newNode.value < node.value) {
            if (node.left === null) {
                node.left = newNode;
            }
            else {
                this.insertNuts(node.left, newNode);
            }
        }
        else {
            if (node.right === null) {
                node.right = newNode;
            }
            else {
                this.insertNuts(node.right, newNode);
            }
        }
    };
    BST.prototype.search = function (value) {
        return this.searchNuts(this.root, value);
    };
    BST.prototype.searchNuts = function (node, value) {
        if (node === null) {
            return false;
        }
        if (value < node.value) {
            return this.searchNuts(node.left, value);
        }
        else if (value > node.value) {
            return this.searchNuts(node.right, value);
        }
        else {
            return true;
        }
    };
    BST.prototype.inorderTraversal = function (callback) {
        this.inorderTraversalNuts(this.root, callback);
    };
    BST.prototype.inorderTraversalNuts = function (node, callback) {
        if (node !== null) {
            this.inorderTraversalNuts(node.left, callback);
            callback(node.value);
            this.inorderTraversalNuts(node.right, callback);
        }
    };
    return BST;
}());
var bst = new BST();
bst.insert(5);
bst.insert(3);
bst.insert(7);
bst.insert(2);
bst.insert(4);
bst.insert(6);
bst.insert(8);
console.log(bst.search(3));
console.log(bst.search(9));
