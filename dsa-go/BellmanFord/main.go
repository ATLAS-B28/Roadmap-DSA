package main

import (
	"fmt"
	"math"
)

type Edge struct {
	src  int
	dest int
	wt   float64
}

func BellmanFord(graph []Edge, numVertices int, src int) ([]float64, []int) {
	dist := make([]float64, numVertices)
	prev := make([]int, numVertices)

	for i := 0; i < numVertices; i++ {
		dist[i] = math.Inf(1)
		prev[i] = -1
	}

	dist[src] = 0

	for i := 0; i < numVertices-1; i++ {
		for j := 0; j < len(graph); j++ {
			u := graph[j].src
			v := graph[j].dest
			wtj := graph[j].wt

			if dist[u]+wtj < dist[v] {
				dist[v] = dist[u] + wtj
				prev[v] = u
			}
		}
	}

	for j := 0; j < len(graph); j++ {
		u := graph[j].src
		v := graph[j].dest
		wtj := graph[j].wt

		if dist[u]+wtj < dist[v] {
			return nil, nil
		}
	}

	return dist, prev
}

func PrintPath(prev []int, v int) {
	if prev[v] != -1 {
		PrintPath(prev, prev[v])
	}
	fmt.Printf("%d ", v)
}

func main() {

	graph := []Edge{
		{0, 1, 6},
		{0, 2, 7},
		{1, 2, 8},
		{1, 3, -4},
		{1, 4, 5},
		{2, 3, 9},
		{3, 4, 2},
	}

	numVertices := 5
	src := 0

	dist, prev := BellmanFord(graph, numVertices, src)

	if dist == nil {
		fmt.Println("Graph contains negative weight cycle")
	} else {
		fmt.Println("Shortest distances from source:", dist)
		fmt.Println("Shortest paths:")
		for i := 0; i < numVertices; i++ {
			fmt.Printf("Path  to vertex %d: ", i)
			PrintPath(prev, i)
			fmt.Println()
		}
	}
}
