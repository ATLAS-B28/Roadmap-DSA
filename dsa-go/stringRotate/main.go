package main

import "fmt"

func rotateString(s string, position int) string {
	length := len(s)
	if length <= 1 || position%length == 0 {
		return s
	}

	position %= length
	rotated := s[length-position:]
	return rotated + s[:length-position]
}
func main() {
	s := "hello"
	rotated := rotateString(s, 4)
	fmt.Println(rotated)
}
