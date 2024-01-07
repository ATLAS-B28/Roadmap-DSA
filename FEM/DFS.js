/**
 * @class TreeNode
 */
class TreeNode {
    /**
     * @param {number} value
     */
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

/**
 * @param {TreeNode} root
 * @returns {number[]}
 */
function dfsPreOrder(root) {
    const result = [];
    /**
     * @param {TreeNode} node
     */
    function traverse(node) {
        if(node === null) {
            return;
        }

        result.push(node.value);
        traverse(node.left);
        traverse(node.right);
    }
    traverse(root);
    return result;
}

/**
 * @param {TreeNode} root
 * @returns {number[]}
 */
function dfsInOrder(root) {
    const result = [];

    /**
     * @param {TreeNode} node
     */

    function traverse(node) {
        if(node === null) {
            return;
        }

        traverse(node.left);
        result.push(node.value);
        traverse(node.right);
    }
    traverse(root);
    return result;
}

/**
 * @param {TreeNode} root
 * @returns {number[]}
 */
function dfsPostInOrder(root) {
    const result = [];

    /**
     * @param {TreeNode} node
     */

    function traverse(node) {
        if(node === null) {
            return;
        }

        traverse(node.left);
        traverse(node.right);
        result.push(node.value);
    }
    traverse(root);
    return result;
}

const root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(5);
root.right.left = new TreeNode(6);
root.right.right = new TreeNode(7);

console.log(root);
console.log("dfsPreOrder");
console.log(dfsPreOrder(root));
console.log("dfsInOrder");
console.log(dfsInOrder(root));
console.log("dfsPostInOrder");
console.log(dfsPostInOrder(root));