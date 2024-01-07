package main

import (
	"fmt"
	"sort"
)

type Edge struct {
	src, dest, wt int
}

type Graph struct {
	V     int
	Edges []Edge
}

func newGraph(V int) *Graph {
	return &Graph{
		V:     V,
		Edges: []Edge{},
	}
}

func (g *Graph) AddEdge(src, dest, wt int) {
	g.Edges = append(g.Edges, Edge{src: src, dest: dest, wt: wt})
}

type Subset struct {
	parent, rank int
}

func find(subsets []Subset, i int) int {
	if subsets[i].parent != i {
		subsets[i].parent = find(subsets, subsets[i].parent)
	}
	return subsets[i].parent
}

func union(subsets []Subset, x, y int) {
	xroot := find(subsets, x)
	yroot := find(subsets, y)

	if subsets[xroot].rank < subsets[yroot].rank {
		subsets[xroot].parent = yroot
	} else if subsets[xroot].rank > subsets[yroot].rank {
		subsets[yroot].parent = xroot
	} else {
		subsets[yroot].parent = xroot
		subsets[xroot].rank++
	}
}

func (g *Graph) KMST() []Edge {
	result := []Edge{}
	subsets := make([]Subset, g.V)

	for i := 0; i < g.V; i++ {
		subsets[i].parent = i
		subsets[i].rank = 0
	}

	sort.Slice(g.Edges, func(i, j int) bool {
		return g.Edges[i].wt < g.Edges[j].wt
	})

	for _, edge := range g.Edges {
		x := find(subsets, edge.src)
		y := find(subsets, edge.dest)

		if x != y {
			result = append(result, edge)
			union(subsets, x, y)
		}
	}

	return result
}

func main() {
	V := 4
	g := newGraph(V)

	g.AddEdge(0, 1, 10)
	g.AddEdge(0, 2, 6)
	g.AddEdge(0, 3, 5)
	g.AddEdge(1, 3, 15)
	g.AddEdge(2, 3, 4)

	mst := g.KMST()

	fmt.Println("MST:")
	for i, edge := range mst {
		fmt.Printf("Edge %d: %d -- %d, weight: %d\n", i, edge.src, edge.dest, edge.wt)
	}
}
