package main

import (
	"fmt"
)

type Node struct {
	value    int
	children []*Node
}

func newNode(value int) *Node {
	return &Node{
		value:    value,
		children: []*Node{},
	}
}

func (n *Node) AddChild(child *Node) {
	n.children = append(n.children, child)
}

func DFS(node *Node) {
	if node == nil {
		return
	}

	visited := make(map[*Node]bool)
	stack := []*Node{node}

	for len(stack) > 0 {
		current := stack[len(stack)-1]
		stack := stack[:len(stack)-1]

		if !visited[current] {

			visited[current] = true

			fmt.Printf("%d ", current.value)

			for _, child := range current.children {
				if !visited[child] {
					stack = append(stack, child)
				}
			}

			for i := len(current.children) - 1; i >= 0; i-- {
				child := current.children[i]
				if !visited[child] {
					stack = append(stack, child)
				}
			}

		}
	}

}

func main() {

	root := newNode(1)
	node2 := newNode(2)
	node3 := newNode(3)
	node4 := newNode(4)
	node5 := newNode(5)

	root.AddChild(node2)
	root.AddChild(node3)
	node2.AddChild(node4)
	node3.AddChild(node5)

	// Perform DFS starting from the root node
	DFS(root)
}
