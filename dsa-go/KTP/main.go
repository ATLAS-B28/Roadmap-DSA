package main

import "fmt"

const boardSize = 8

var moves = [][2]int{
	{-2, -1}, {-2, 1},
	{-1, -2}, {-1, 2},
	{1, -2}, {1, 2},
	{2, -1}, {2, 1},
}

func isSafe(board [][]int, row, col int) bool {
	return row >= 0 &&
		row < boardSize &&
		col >= 0 &&
		col < boardSize &&
		board[row][col] == -1
}

func solveKnightTourUtil(board [][]int, row, col, move int) bool {
	if move == boardSize*boardSize {
		return true
	}

	for _, m := range moves {
		nextRow := row + m[0]
		nextCol := col + m[1]

		if isSafe(board, nextRow, nextCol) {
			board[nextRow][nextCol] = move

			if solveKnightTourUtil(board, nextRow, nextCol, move+1) {
				return true
			}

			board[nextRow][nextCol] = -1
		}
	}
	return false
}

func printBoard(board [][]int) {
	for _, row := range board {
		for _, cell := range row {
			fmt.Printf("%2d ", cell)
		}
		fmt.Println()
	}
}

func solveKnightTour() [][]int {
	board := make([][]int, boardSize)
	for i := 0; i < boardSize; i++ {
		board[i] = make([]int, boardSize)
		for j := 0; j < boardSize; j++ {
			board[i][j] = -1
		}
	}

	board[0][0] = 0

	if solveKnightTourUtil(board, 0, 0, 1) {
		return board
	}

	return nil
}

func main() {
	board := solveKnightTour()

	if board != nil {
		fmt.Println("Solution:")
		printBoard(board)
	} else {
		fmt.Println("No solution exists")
	}
}
