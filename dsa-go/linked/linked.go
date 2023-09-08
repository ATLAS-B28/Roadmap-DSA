package main

import "fmt"

type Node struct {
	data int
	next *Node
}
type LL struct {
	head *Node
}

func (l *LL) Add(data int) {
	newNode := &Node{data: data, next: nil}
	if l.head == nil {
		l.head = newNode
	} else {
		current := l.head
		for current.next != nil {
			current = current.next
		}
		current.next = newNode
	}
}

func (l *LL) Delete(data int) {
	if l.head == nil {
		return
	}
	if l.head.data == data {
		l.head = l.head.next
		return
	}
	current := l.head
	for current.next != nil {
		if current.next.data == data {
			current.next = current.next.next
			return
		}
		current = current.next
	}
}

func (l *LL) Print() {
	current := l.head
	for current != nil {
		fmt.Print(current.data, " ")
		current = current.next
	}
	fmt.Println()
}
func main() {
	list := &LL{}
	list.Add(10)
	list.Add(20)
	list.Add(30)
	list.Print()
	list.Delete(20)
	list.Print()
}
