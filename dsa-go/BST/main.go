package main

import "fmt"

type Node struct {
	key   int
	Left  *Node
	Right *Node
}

type BST struct {
	Root *Node
}

func (bst *BST) Insert(key int) {
	newNode := &Node{key: key}

	if bst.Root == nil {
		bst.Root = newNode
	} else {
		bst.insertNode(bst.Root, newNode)
	}
}

func (bst *BST) insertNode(node, newNode *Node) {
	if newNode.key < node.key {
		if node.Left == nil {
			node.Left = newNode
		} else {
			bst.insertNode(node.Left, newNode)
		}
	} else {
		if node.Right == nil {
			node.Right = newNode
		} else {
			bst.insertNode(node.Right, newNode)
		}
	}
}

func (bst *BST) Search(key int) bool {
	return bst.searchNode(bst.Root, key)
}

func (bst *BST) searchNode(node *Node, key int) bool {
	if node == nil {
		return false
	}

	if key < node.key {
		return bst.searchNode(node.Left, key)
	} else if key > node.key {
		return bst.searchNode(node.Right, key)
	}

	return true
}

func main() {
	bst := &BST{}

	bst.Insert(50)
	bst.Insert(40)
	bst.Insert(60)
	bst.Insert(30)

	fmt.Println(bst.Search(40))
	fmt.Println(bst.Search(100))
}
