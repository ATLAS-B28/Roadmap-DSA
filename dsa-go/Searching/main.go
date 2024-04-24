package main

import "fmt"

func binarySearch(nums []int, target int) int {
	left, right := 0, len(nums)-1

	for left <= right {
		mid := left + (right-left)/2

		if nums[mid] == target {
			return mid
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return -1
}

func linaerSearch(nums []int, target int) int {
	for i, num := range nums {
		if num == target {
			return i
		}
	}
	return -1
}
func main() {
	nums := []int{1, 3, 5, 7, 9, 11, 13}
	target := 7

	index := binarySearch(nums, target)
	indexLinear := linaerSearch(nums, target)

	if index != -1 {
		fmt.Printf("Target found at index: %d\n", index)
	} else {
		fmt.Printf("Target not found\n")
	}

	if indexLinear != -1 {
		fmt.Printf("Target found at index: %d\n", indexLinear)
	} else {
		fmt.Printf("Target not found\n")
	}
}
