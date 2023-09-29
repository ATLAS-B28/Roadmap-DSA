package tree;
import java.util.*;
public class Maze {
    private final int[][] maze;
    private final int rows;
    private final int cols;
    private final int startRow;
    private final int startCol;
    private final int endRow;
    private final int endCol;
    private final boolean[][] visited;
    private final List<String> solutions;

    public Maze(int[][] maze,int startRow,int startCol,int endRow,int endCol){
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
        this.visited = new boolean[rows][cols];
        this.solutions = new ArrayList<>();
    }
    public List<String> solve(){
        explore(startRow,startCol);
        return solutions;
    }
    private boolean explore(int row,int col){
        //check if current position is valid
        if(row<0 || row>=rows || col<0 || col>=cols || maze[row][col]==1 || visited[row][col]){
            return false;
        }
        //mark the current position as visited
        visited[row][col] = true;
        //check if current position is the end position
        if(row == endRow && col == endCol){
            solutions.add("("+row+","+col+")");
            return true;
        }
        //explore the neighboring positions in a specified order
        if(explore(row-1,col)){
            //Up
            solutions.add("("+row+","+col+")");
            return true;
        }
        if(explore(row,col+1)){
            //right
            solutions.add("("+row+","+col+")");
            return true;
        }
        if(explore(row+1,col)){
            //down
            solutions.add("("+row+","+col+")");
            return true;
        }
        if(explore(row,col-1)){
            //left
            solutions.add("("+row+","+col+")");
            return true;
        }
        //if none of the neighboring positions are valid, backtrack
        return false;
    }
    public static void main(String[] args){
        int[][] maze = {
                {0, 1, 0, 0},
                {0, 1, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 0}
        };
        Maze m = new Maze(maze,0,0,3,3);
        List<String> solution =  m.solve();
        if(solution.isEmpty()){
            System.out.println("No solution");
        }else{
            System.out.println("Solution: ");
            for(String position : solution){
                System.out.println(position);
            }
        }
    }
}
