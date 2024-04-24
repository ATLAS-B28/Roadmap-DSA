package main

import (
	"container/heap"
	"fmt"
)

//using prority queue

type Edge struct {
	Weight int
	Start  int
	End    int
}

type PriorityQueue []*Edge

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
	return pq[i].Weight < pq[j].Weight
}

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
	item := x.(*Edge)
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	*pq = old[0 : n-1]
	return item
}
func Prim(graph [][]int) int {
	numVertices := len(graph)
	parent := make([]int, numVertices)
	key := make([]int, numVertices)
	mst := make([]bool, numVertices)

	pq := make(PriorityQueue, 0)
	heap.Init(&pq)

	for i := 0; i < numVertices; i++ {
		key[i] = 1<<31 - 1
		/*
			This expression shifts the binary representation
			of the number 1 to the left by 31 bits, and then
			subtracts 1. The result is 2147483647, which is
			the maximum value for a 32-bit signed integer.
		*/
		mst[i] = false
	}

	key[0] = 0
	heap.Push(&pq, &Edge{Weight: 0, Start: 0, End: 0})

	for pq.Len() > 0 {
		u := heap.Pop(&pq).(*Edge).End

		if mst[u] {
			continue
		}
		mst[u] = true

		for v := 0; v < numVertices; v++ {
			if graph[u][v] != 0 && !mst[v] && graph[u][v] < key[v] {
				parent[u] = v
				key[v] = graph[u][v]
				heap.Push(&pq, &Edge{Weight: graph[u][v], Start: u, End: v})
			}
		}
	}

	minWt := 0
	for i := 1; i < numVertices; i++ {
		minWt += graph[parent[i]][i]
	}

	return minWt
}

func main() {
	graph := [][]int{
		{0, 2, 0, 6, 0},
		{2, 0, 3, 8, 5},
		{0, 3, 0, 0, 7},
		{6, 8, 0, 0, 9},
		{0, 5, 7, 9, 0},
	}

	minWt := Prim(graph)
	fmt.Println("Minimum Spanning Tree: ", minWt)
}
