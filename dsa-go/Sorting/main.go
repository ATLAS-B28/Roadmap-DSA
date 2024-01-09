package main

import "fmt"

/*func bubbleSort(arr []int) {
	n := len(arr)

	for i := 0; i < n-1; i++ {
		for j := 0; j < n-i-1; j++ {
			if arr[j] > arr[j+1] {
				arr[j], arr[j+1] = arr[j+1], arr[j]
			}
		}
	}
}


func selectionSort(arr []int) {
	n := len(arr)

	for i := 0; i < n-1; i++ {
		minIndex := i
		for j := i + 1; j < n; j++ {
			if arr[j] < arr[minIndex] {
				minIndex = j
			}
		}
		arr[i], arr[minIndex] = arr[minIndex], arr[i]
	}
}
*/

/*func insertionSort(arr []int) {
	n := len(arr)

	for i := 1; i < n; i++ {
		key := arr[i]
		j := i - 1
		for j >= 0 && arr[j] > key {
			arr[j+1] = arr[j]
			j = j - 1
		}
		arr[j+1] = key
	}
}
*/
/*
func quickSort(arr []int) {
	if len(arr) <= 1 {
		return
	}

	pivot := arr[len(arr)-1]
	i := 0

	for j := 0; j < len(arr)-1; j++ {
		if arr[j] < pivot {
			arr[i], arr[j] = arr[j], arr[i]
			i++ //only if element is less than pivot
			//ensuring that all the elements
			//smaller then pivot are placed before
			//the index i
		}
	}
	//place the pivot at correct position
	arr[i], arr[len(arr)-1] = arr[len(arr)-1], arr[i]
	//recursive calls for sub-arrays before and after the pivot
	quickSort(arr[:i])
	quickSort(arr[i+1:])
}
*/
/*
func mergeSort(arr []int) []int {
	if len(arr) <= 1 {
		return arr
	}

	mid := len(arr) / 2
	left := mergeSort(arr[:mid])
	right := mergeSort(arr[mid:])

	return merge(left, right)
}

func merge(left, right []int) []int {
	result := make([]int, 0, len(left)+len(right))
	i, j := 0, 0

	for i < len(left) && j < len(right) {
		if left[i] <= right[j] {
			result = append(result, left[i])
			i++
		} else {
			result = append(result, right[j])
			j++
		}
	}
	result = append(result, left[i:]...)
	result = append(result, right[j:]...)
	return result
}
*/

func heapSort(arr []int) {
	n := len(arr)

	//build max heap
	for i := n/2 - 1; i >= 0; i-- {
		heapify(arr, n, i)
	}
}

func heapify(arr []int, n, i int) {
	largest := i
	left := 2*i + 1
	right := 2*i + 2

	//find largest element among root, left child and right child
	if left < n && arr[left] > arr[largest] {
		largest = left
	}
	if right < n && arr[right] > arr[largest] {
		largest = right
	}

	//if the largest element is not the root
	//swap them and call heapify
	if largest != i {
		arr[i], arr[largest] = arr[largest], arr[i]
		heapify(arr, n, largest)
	}
}

func main() {
	arr := []int{64, 34, 25, 12, 22, 11, 90}
	fmt.Println("Original array: ", arr)
	//bubbleSort(arr)
	//selectionSort(arr)
	//insertionSort(arr)
	//quickSort(arr)
	//mergeSort(arr)
	heapSort(arr)
	fmt.Println("Sorted array: ", arr)
}
