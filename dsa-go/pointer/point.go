package main

import "fmt"

func main() {
	num := 10
	ptr := &num // &num means assign the address of num to ptr variable

	fmt.Println("Value of num: ", num)
	fmt.Println("Address of num: ", &num)
	fmt.Println("Value of ptr: ", ptr)
	fmt.Println("Address of ptr: ", &ptr)
	fmt.Println("Dereferenced value: ", *ptr) //prints the value
	//dereferences the value i.e. we obtain the value
	*ptr = 20
	fmt.Println("New value of num: ", num)
}
