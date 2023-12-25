package main

import "fmt"

type Stack struct {
	items []int
}

func (s *Stack) Push(item int) {
	s.items = append(s.items, item)
}

func (s *Stack) IsEmpty() bool {
	return len(s.items) == 0
}

func (s *Stack) Pop() (int, error) {
	if s.IsEmpty() {
		return 0, fmt.Errorf("Stack is empty")
	}

	index := len(s.items) - 1
	item := s.items[index]
	s.items = s.items[:index] // new slice range is from 0 to index - 1

	return item, nil
}

func (s *Stack) Peek() (int, error) {
	if s.IsEmpty() {
		return 0, fmt.Errorf("Stack is empty")
	}
	return s.items[len(s.items)-1], nil
}

func main() {
	stack := Stack{}

	stack.Push(1)
	stack.Push(2)
	stack.Push(3)

	fmt.Println(stack.IsEmpty())

	item, _ := stack.Peek()
	fmt.Println(item)

	for !stack.IsEmpty() {
		item, _ := stack.Pop()
		fmt.Println(item)
	}

	fmt.Println(stack.IsEmpty())
}
