package main

import "fmt"

type Node struct {
	data int
	prev *Node
	next *Node
}
type DLL struct {
	head *Node
	tail *Node
}

func (dll *DLL) AddToFornt(data int) {
	newNode := &Node{data: data, prev: nil, next: nil}
	if dll.head == nil {
		dll.head = newNode
		dll.tail = newNode
	} else {
		newNode.next = dll.head
		dll.head.prev = newNode
		dll.head = newNode
	}
}

func (dll *DLL) AddToBack(data int) {
	newNode := &Node{data: data, prev: nil, next: nil}

	if dll.head == nil {
		dll.head = newNode
		dll.tail = newNode
	} else {
		dll.tail.next = newNode
		newNode.prev = dll.tail
		dll.tail = newNode
	}
}

func (dll *DLL) Delete(data int) {
	if dll.head == nil {
		return
	}
	if dll.head.data == data {
		dll.head = dll.head.next
		return
	}
	current := dll.head
	for current.next != nil {
		if current.next.data == data {
			current.next = current.next.next
			return
		}
		current = current.next
	}
}

func (dll *DLL) DisplayForward() {
	current := dll.head
	for current != nil {
		fmt.Print(current.data, "->")
		current = current.next
	}
	fmt.Println()
}

func (dll *DLL) DisplayBackward() {
	current := dll.head
	for current != nil {
		fmt.Print(current.data, "->")
		current = current.prev
	}
	fmt.Println()
}

func main() {
	dll := DLL{}
	dll.AddToFornt(10)
	dll.AddToFornt(20)
	dll.AddToBack(30)
	dll.DisplayForward()
	dll.Delete(20)
	dll.DisplayBackward()
}
