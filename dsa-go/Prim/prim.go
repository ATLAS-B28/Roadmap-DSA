package main

import (
	"container/heap"
	"fmt"
)

type Edge struct {
	u, v, w int
}

type Graph struct {
	n     int
	edges []Edge
	adj   [][]Edge
}

func (g *Graph) addEdge(u, v, w int) {
	g.adj[u] = append(g.adj[u], Edge{u, v, w})
	g.adj[v] = append(g.adj[v], Edge{v, u, w})
	g.edges = append(g.edges, Edge{u, v, w})
}

type EdgeHeap []Edge

// Len implements heap.Interface.
func (h EdgeHeap) Len() int {
	return len(h)
}

func (h EdgeHeap) Less(i, j int) bool {
	return h[i].w < h[j].w
}
func (h EdgeHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *EdgeHeap) Push(x interface{}) {
	*h = append(*h, x.(Edge))
}
func (h *EdgeHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func (g *Graph) prim() int {
	visited := make([]bool, g.n)
	h := &EdgeHeap{}
	heap.Push(h, Edge{-1, 0, 0})
	minWeight := 0
	for h.Len() > 0 {
		e := heap.Pop(h).(Edge)
		if visited[e.v] {
			continue
		}
		visited[e.v] = true
		minWeight += e.w
		for _, edge := range g.adj[e.v] {
			if !visited[edge.v] {
				heap.Push(h, edge)
			}
		}
	}
	return minWeight
}

func main() {
	g := &Graph{n: 5, adj: make([][]Edge, 0)}

	g.addEdge(0, 1, 2)
	g.addEdge(0, 3, 6)
	g.addEdge(1, 2, 3)
	g.addEdge(1, 3, 8)
	g.addEdge(1, 4, 5)
	g.addEdge(2, 4, 7)
	g.addEdge(3, 4, 9)

	minWeight := g.prim()

	fmt.Println("Minimum weight:", minWeight)
}
