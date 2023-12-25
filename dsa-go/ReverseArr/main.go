package main

import "fmt"

func rotateArr(arr []int, positions int) {
	n := len(arr)
	//handle cases where positions is greater than or equal to n
	positions = positions % n
	if positions < 0 {
		positions += n
	}

	if positions == 0 || n == 0 {
		return //no rotation needed
	}
	//reverse the 1st positions elements
	reverse(arr, 0, positions-1)
	//reverse the remaining positions elements
	reverse(arr, positions, n-1)
	//reverse the entire array
	reverse(arr, 0, n-1)
}

func reverse(arr []int, start int, end int) {
	for i := start; i < (start+end+1)/2; i++ {
		arr[i], arr[end-i+start] = arr[end-i+start], arr[i]
	}
}

func main() {
	arr := []int{1, 2, 3, 4, 5, 6}
	positions := 2
	rotateArr(arr, positions)
	fmt.Println(arr)
}
