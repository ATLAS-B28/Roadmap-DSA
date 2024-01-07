/**
 * @param {number} n
 * @returns {string[][]}
 */

function SNQ(n) {
    /**
     * @param {string[][]} board
     * @param {number} row
     * @param {number} col
     * @returns {boolean}       
    */
   function isSafe(board, row, col) {
    //Check the current row on the left side
    for(let i = 0; i < col; i++) {
        if(board[row][i] === 'Q'){
            return false;
        }
    }
    //check the upper diagonal on the left side
    for(let i = row, j = col; i >= 0 && j >= 0; i--, j--) {
        if(board[i][j] === 'Q') {
            return false;
        }
    }
    //check the lower diagonal on the left side
    for(let i = row,j = col; i < n && j >= 0; i++, j--) {
        if(board[i][j] === 'Q') {
            return false;
        }
    }

    return true;
   }

   /**
    * @param {string[][]} board
    * @param {number} col
    * @param {string[][]} solutions
    */
   function backTrack(board, col, solutions) {
    //Base call: all queens are placed
    if(col === n) {
        //Add the current board state to the solutions array
        solutions.push(board.map(row => row.join('')));
        return;
    }
    //try placing a queen in each row of current column
    for(let row = 0; row < n; row++) {
        if(isSafe(board, row, col)) {
            //place the queen at the current position
            board[row][col] = 'Q';
            //Recur for the next column
            backTrack(board, col+1, solutions);
            //remove the queen form current position (backtracking step)
            board[row][col] = '.';
        }
    }
    return true;
   }
   //initialize the chessboard as 2d array of '.' characters
   const board = Array.from({length: n}, () => Array(n).fill('.'));
   const solutions = [];

   backTrack(board, 0, solutions);

   return solutions;
}

const n = 4;
const solutions = SNQ(n);

console.log(`Solutions for N = ${n}: `);
solutions.forEach((board, id) => {
    console.log(`Solution ${id+1}: `);
    board.forEach(row => console.log(row.toString().split(',').join(' ')));
    console.log();
});

