//breath first search

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

func BFS(root *Node) {
	if root == nil {
		return
	}

	visited := make(map[*Node]bool)
	queue := []*Node{root}

	for len(queue) > 0 {
		node := queue[0]
		queue = queue[1:]

		if visited[node] {
			continue
		}

		fmt.Printf("%d ", node.value)

		visited[node] = true

		for _, child := range node.children {
			if !visited[child] {
				queue = append(queue, child)
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
	node6 := newNode(6)

	root.AddChild(node2)
	root.AddChild(node3)
	node2.AddChild(node4)
	node3.AddChild(node5)
	node3.AddChild(node6)

	BFS(root)
}
