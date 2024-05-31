class TreeNode:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None
    
    def __str__(self):
        return str(self.key)

class BST:
    def __init__(self):
        self.root = None

    def insert(self, key):
        if self.root is None:
            self.root = TreeNode(key)
        else:
            self._insert_recursive(self.root, key)

    def _insert_recursive(self, curr_node, key):
        if key < curr_node.key:
            if curr_node.left is None:
                curr_node.left = TreeNode(key)
            else:
                self._insert_recursive(curr_node.left, key)
        else:
            if curr_node.right is None:
                curr_node.right = TreeNode(key)
            else:
                self._insert_recursive(curr_node.right, key)

    def search(self, key):
        return self._search_recursive(self.root, key)
    
    def _search_recursive(self, curr_node, key):
        if curr_node is None or curr_node.key == key:
            return curr_node
        if key < curr_node.key:
            return self._search_recursive(curr_node.left, key)
        else:
            return self._search_recursive(curr_node.right, key)
        
    def delete(self, key):
        if self.root is None:
            return
        self._delete_recursive(self.root, key)

    def _delete_recursive(self, curr_node, key):
        if key < curr_node.key:
            curr_node.left = self._delete_recursive(curr_node.left, key)
        elif key > curr_node.key:
            curr_node.right = self._delete_recursive(curr_node.right, key)
        else:
            if curr_node.left is None:
                temp = curr_node.right
                curr_node = None
                return temp
            elif curr_node.right is None:
                temp = curr_node.left
                curr_node = None
                return temp
            temp = self._min_val(curr_node.right)
            curr_node.right.key = temp.key
            curr_node.right = self._delete_recursive(curr_node.right, temp.key)
    
    def _min_val(self, node):
        curr = node
        while curr.left is not None:
            curr = curr.left
        return curr

    def inorder_traversal(self):
        self._inorder_recursive(self.root)
    
    def _inorder_recursive(self, curr_node):
        if curr_node is not None:
            self._inorder_recursive(curr_node.left)
            print(curr_node)
            self._inorder_recursive(curr_node.right)

    def preorder_traversal(self):
        self._preorder_recursive(self.root)
    
    def _preorder_recursive(self, curr_node):
        if curr_node is not None:
            print(curr_node)
            self._preorder_recursive(curr_node.left)
            self._preorder_recursive(curr_node.right)

    def postorder_traversal(self):
        self._postorder_recursive(self.root)
    
    def _postorder_recursive(self, curr_node):
        if curr_node is not None:
            self._postorder_recursive(curr_node.left)
            self._postorder_recursive(curr_node.right)
            print(curr_node)
    
bst = BST()

bst.insert(5)
bst.insert(3)
bst.insert(7)
bst.insert(2)
bst.insert(4)
bst.insert(6)
bst.insert(8)

print(bst.search(3))
print(bst.search(9))

bst.delete(5)
print(bst.search(5))

bst.inorder_traversal()
bst.preorder_traversal()
bst.postorder_traversal()