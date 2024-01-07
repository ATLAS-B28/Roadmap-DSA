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
function bfs(root) {
    /**
     * @typedef {Object} QueueItem
     * @property {TreeNode} node
     * @property {number} level
     */

    /** @type {QueueItem[]} */
    const queue = [];
    const result = [];

    if(root === null) {
        return result;
    }

    queue.push({node: root, level: 0});

    while(queue.length > 0) {
        const {node, level} = queue.shift();

        result.push(node.value);

        if(node.left !== null) {
            queue.push({node: node.left, level: level + 1});
        }

        if(node.right !== null) {
            queue.push({node: node.right, level: level + 1});
        }
    }
    return result;
}

const root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(5);
root.right.left = new TreeNode(6);
root.right.right = new TreeNode(7);

const bfsResult = bfs(root.right);
console.log("BFS Result: ", bfsResult);