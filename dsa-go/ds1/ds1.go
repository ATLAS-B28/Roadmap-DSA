package main

import "fmt"

type Stack []int

func (s *Stack) Push(value int) {
	*s = append(*s, value)
}
func (s *Stack) Pop() (int, error) {
	if s.isEmpty() {
		return 0, fmt.Errorf("Stack is empty")
	}
	index := len(*s) - 1
	value := (*s)[index]
	*s = (*s)[:index]
	return value, nil
}

func (s *Stack) isEmpty() bool {
	return len(*s) == 0
}
func main() {
	stack := Stack{}
	stack.Push(1)
	stack.Push(2)
	stack.Push(3)
	fmt.Println(stack)
	stack.Pop()
	fmt.Println(stack)
}
