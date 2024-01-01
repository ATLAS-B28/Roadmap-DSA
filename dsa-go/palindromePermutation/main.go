package main

import "fmt"

func isPalindromePermutation(s string) bool {
	freq := make(map[rune]int)

	for _, char := range s {
		freq[char]++
	}

	oddCount := 0
	for _, count := range freq {
		if count%2 != 0 {
			oddCount++
		}
	}
	return oddCount <= 1
}

func main() {
	s := "tactcoa"
	result := isPalindromePermutation(s)
	fmt.Println(result)
}
