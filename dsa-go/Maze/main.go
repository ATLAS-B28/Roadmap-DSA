package main

import "fmt"

type Point struct {
	x, y int
}

var directions = []Point{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}

func solveMaze(maze [][]byte, start, end Point, rows, cols int) []Point {
	visited := make([][]bool, rows)
	for i := 0; i < rows; i++ {
		visited[i] = make([]bool, cols)
	}

	path := make([]Point, 0)
	if dfs(maze, visited, start, end, &path, rows, cols) {
		return path
	}

	return nil
}

func dfs(maze [][]byte, visited [][]bool, curr, end Point, path *[]Point, rows, cols int) bool {
	if curr.x == end.x && curr.y == end.y {
		*path = append(*path, end)
		return true
	}

	if isSafe(maze, visited, curr, rows, cols) {
		*path = append(*path, curr)
		visited[curr.x][curr.y] = true

		for _, dir := range directions {
			next := Point{curr.x + dir.x, curr.y + dir.y}

			if dfs(maze, visited, next, end, path, rows, cols) {
				return true
			}

		}

		*path = (*path)[:len(*path)-1]
		visited[curr.x][curr.y] = false
	}

	return false
}

func isSafe(maze [][]byte, visited [][]bool, p Point, rows, cols int) bool {
	return p.x >= 0 && p.x < rows && p.y >= 0 && p.y < cols && maze[p.x][p.y] == ' ' && !visited[p.x][p.y]
}

func main() {
	maze := [][]byte{
		{' ', ' ', ' ', '*', ' ', ' '},
		{' ', '*', ' ', '*', ' ', ' '},
		{' ', ' ', ' ', '*', ' ', ' '},
		{' ', ' ', ' ', '*', '*', ' '},
		{' ', ' ', ' ', '*', ' ', ' '},
	}
	start := Point{0, 0}
	end := Point{4, 2}

	rows := len(maze)
	cols := len(maze[0])

	path := solveMaze(maze, start, end, rows, cols)
	if path != nil {
		fmt.Println("Path found")
		for _, p := range path {
			fmt.Printf("(%d, %d) ->", p.x, p.y)
		}

		fmt.Println()
	} else {
		fmt.Println("Path not found")
	}
}
