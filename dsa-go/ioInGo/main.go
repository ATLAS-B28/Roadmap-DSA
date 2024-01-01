package main

import "fmt"

func main() {
	fmt.Println("Hello World")

	name := "Aditya"
	age := 21
	fmt.Printf("Name: %s, Age: %d\n", name, age)

	var input string
	fmt.Print("Enter your name: ")
	fmt.Scan(&input)
	fmt.Println("Hello ", input)

	var num int
	fmt.Print("Enter a number: ")
	fmt.Scan(&num)
	fmt.Println("Your number is ", num)
}
