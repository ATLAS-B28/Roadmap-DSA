package main

import (
	"fmt"

	"./dsa-go/greetings"
)

func main() {
	fmt.Println("Hello From Go!!")
	message := greetings.Hello("Aditya")
	fmt.Println(message)

}
