#include <iostream>
#include <vector>

using namespace std;

bool isSafe(vector<vector<int>>& board,int row,int col,int N) {
    //check if there is a queen in the same column
    for(int i = 0; i < row; i++) {
        if(board[i][col] == 1) {
            return false;
        }
    }

    //check if there is a queen in the upper left diagonal
    for(int i = row,j = col; i >= 0 && j >= 0; i--, j--) {
        if(board[i][j] == 1) {
            return false;
        }
    }

    //check if there is a queen in the upper right diagonal
    for(int i = row,j = col; i >= 0 && j < N; i--, j++) {
        if(board[i][j] == 1) {
            return false;
        }
    }

    return true;
}

bool solveQueenUtil(vector<vector<int>>& board,int row,int N) {
    if(row == N) {
        //all queens have been placed, solution found
        return true;
    }

    for(int col = 0; col < N; col++) {
        if(isSafe(board, row, col, N)) {

            board[row][col] = 1;

            if(solveQueenUtil(board, row + 1, N)) {
                return true;
            }

            board[row][col] = 0;
        }
    }
    return false;
}

void solveNQueens(int N) {
    vector<vector<int>> board(N, vector<int>(N, 0));

    if(solveQueenUtil(board, 0, N)) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 1) {
                    cout << "Q ";
                } else {
                    cout << ". ";
                }
            }
            cout << endl;
        }
    } else {
        cout << "No solution exists." << endl;
    }
}

int main() {
    int N;
    cout << "Enter the value of N: ";
    cin >> N;

    solveNQueens(N);

    return 0;
}