package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Queen{
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        backTrack(board,0,solutions);
        return solutions;
    }
    private static void backTrack(char[][] board,int row,List<List<String>> solutions){
        if(row == board.length){
            solutions.add(constructSolution(board));
            return;
        }
        for(int col=0; col<board.length;col++){
            if(isValid(board,row,col)){
                board[row][col] = 'Q';
                backTrack(board,row+1,solutions);
                board[row][col] = '.';
            }
        }
    }
    private static boolean isValid(char[][] board,int row,int col){
        //check if there is a queen in the same column
        for(int i=0; i<row; i++){
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        //check if there is a queen in the same diagonal (top-left to bottom-right)
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //check if there is a queen in the same diagonal (bottom-left to top-right)
        for(int i=row-1,j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    private static List<String> constructSolution(char[][] board){
        List<String> solution = new ArrayList<>();
        for (char[] chars : board) {
            solution.add(new String(chars));
        }
        return solution;
    }
    public static void main(String[] args){
        List<List<String>> solutions = Collections.unmodifiableList(solveNQueens(4));
        for(List<String> solution:solutions){
            for(String row : solution){
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
