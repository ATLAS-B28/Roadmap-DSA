package array_string;
/*
public class Matrix {
    public static void main(String[] args) {
        int[][] matrix ={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        //modifying
        matrix[1][1] = 0;
        System.out.println(matrix[1][1]);

    }
}*/
/*
public class Matrix{
    public static void main(String[] args){
        int[][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] matrix2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        //check if matrices have same dimensions
        int rows = matrix1.length;//<- horizontal
        int columns = matrix1[0].length;//<- vertical
        //now compare it with matrix2
        if(rows != matrix2.length || columns != matrix2[0].length){
            System.out.println("Matrices cannot be added");
            return;
        }
        //then add
        int[][] result = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        //display
        for(int[] row:result){
            //this iterates over each row of type int
            for(int num: row){
                //this iterates over each element in current row
                System.out.print(num+" ");
            }
            System.out.println();
        }

    }
}
*/
/*
*  int[][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] matrix2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
    i = 0 ,j = 0 and k = 0

*
* */

public class Matrix{
    public static void main(String[] args){
        int[][] matrix1 = {
                {1,2,3},
                {4,5,6}
        };
        int[][] matrix2 = {
                {7,8},
                {9,10},
                {11,12}
        };
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;//<- refers to ele of 1st matrix and col of 2nd matrix
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;
        if(columns1 != rows2){
            System.out.println("Matrices cannot be multiplication");
            return;
        }
        int[][] productMatrix = new int[rows1][columns2];
        for(int i = 0; i < rows1; i++){
            for(int j = 0; j < columns2; j++){
                for(int k =0; k < columns1; k++){
                    productMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                    // k = 0
                    //j = 0 and i = 0
                    //here 1*7 + 2*9 + 3*11
                    /*
                    k = 1, j =0 and i = 0

                    * */
                }
            }
        }
        for(int[] row: productMatrix){
            for(int num: row){
                System.out.println(num+" ");
            }
            System.out.println();
        }
    }
}