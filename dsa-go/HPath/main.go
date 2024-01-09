package main

import (
	"fmt"
)

func printPath(path []int) {
	for _, vertex := range path {
		fmt.Printf("%d ", vertex)
	}
	fmt.Println()
}

func hamiltionPathUtil(
	graph [][]int,
	visited []bool,
	path []int,
	currVertex int,
	numVertices int) {

	visited[currVertex] = true
	path = append(path, currVertex)

	if len(path) == numVertices {
		printPath(path)
	} else {
		for nextVertices := 0; nextVertices < numVertices; nextVertices++ {
			if !visited[nextVertices] && graph[currVertex][nextVertices] == 1 {
				hamiltionPathUtil(graph, visited, path, nextVertices, numVertices)
			}
		}
	}

	visited[currVertex] = false
	path = path[:len(path)-1]
}

func hamiltionPaths(graph [][]int) {
	numVertices := len(graph)

	visited := make([]bool, numVertices)
	path := make([]int, 0)

	for startVertex := 0; startVertex < numVertices; startVertex++ {
		hamiltionPathUtil(graph, visited, path, startVertex, numVertices)
	}
}

func main() {
	var numVertices int
	fmt.Print("Enter the number of vertices: ")
	fmt.Scan(&numVertices)

	graph := make([][]int, numVertices)
	fmt.Println("Enter the adjacency matrix:")
	for i := 0; i < numVertices; i++ {
		graph[i] = make([]int, numVertices)
		for j := 0; j < numVertices; j++ {
			fmt.Scan(&graph[i][j])
		}
	}

	fmt.Println("Hamiltonian paths:")
	hamiltionPaths(graph)
}
