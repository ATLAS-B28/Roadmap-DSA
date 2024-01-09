package main

import "fmt"

func buildPrefixTable(pattern string) []int {

	m := len(pattern)
	prefixTable := make([]int, m)
	length := 0
	i := 1

	for i < m {
		if pattern[i] == pattern[length] {
			length++
			prefixTable[i] = length
			i++
		} else {
			if length != 0 {
				length = prefixTable[length-1]
			} else {
				prefixTable[i] = 0
				i++
			}
		}
	}
	return prefixTable
}

func kmpSearch(text string, pattern string) []int {
	n := len(text)
	m := len(pattern)
	prefixTable := buildPrefixTable(pattern)

	result := []int{}
	i, j := 0, 0
	for i < n {
		if pattern[j] == text[i] {
			i++
			j++
		}

		if j == m {
			result = append(result, i-j)
			j = prefixTable[j-1]
		} else if i < n && pattern[j] != text[i] {
			if j != 0 {
				j = prefixTable[j-1]
			} else {
				i++
			}
		}
	}
	return result
}

func main() {
	text := "abxabcabcaby"
	pattern := "abcaby"

	indeces := kmpSearch(text, pattern)

	if len(indeces) > 0 {
		fmt.Printf("Pattern found at indeces: %v\n", indeces)
	} else {
		fmt.Println("Pattern not found")
	}
}
