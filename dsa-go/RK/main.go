package main

import (
	"fmt"
	"hash/fnv"
)

/*
In this updated version, we import
the hash/fnv package, which provides
the FNV-1a hash algorithm. We use this
package to generate the hash values
for both the pattern and the substrings
in the text.
*/

func RK(pattern, text string) []int {
	patternhash := hash(pattern)
	indices := []int{}

	for i := 0; i <= len(text)-len(pattern); i++ {
		substring := text[i : i+len(pattern)]

		if patternhash == hash(substring) && substring == pattern {
			indices = append(indices, i)
		} else {

			for j := 0; j < len(pattern); j++ {
				if substring[j] != pattern[j] {
					break
				}
				if j == len(pattern)-1 {
					indices = append(indices, i)
				}
			}
		}

	}
	return indices
}

func hash(str string) uint32 {
	h := fnv.New32a()
	h.Write([]byte(str))
	return h.Sum32()
}

func main() {
	text := "abxabcabcabyx"
	pattern := "abcaby"

	indices := RK(pattern, text)

	if len(indices) > 0 {
		fmt.Printf("Pattern found at indices: %v\n", indices)
	} else {
		fmt.Println("Pattern not found")
	}
}
