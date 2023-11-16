package array_string;
import java.util.Random;

class AssortedMethods{//like in CtCI library
    public static int[][] randomMatrix(int rows,int cols,int max,int min){

        int[][] matrix = new int[rows][cols];

        Random random = new Random();

        for(int i = 0; i < rows; i++ ){

            for(int j =0; j < cols; j++){

                matrix[i][j] = random.nextInt(max-min+1)+min;
                /*
                * max-min+1 is used as the bound for the random integer
                * generation to ensure that the generated value falls within the
                * range of max to min.
                * The generated random value is then added
                * to min, resulting in a random integer within the
                * range of min to max.
                * */
            }
        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix){
        for (int[] ints : matrix) {

            for (int anInt : ints) {

                System.out.println(anInt + " ");
            }
            System.out.println();
        }
    }
}
public class RotateMatrix {
    public static boolean rotate(int[][] matrix){

        if(matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int n = matrix.length;

        for(int layer = 0; layer < n/2; layer++){

            int first = layer;

            int last = n - 1 - layer;

            for(int i = first; i < last; i++){

                int offset = i - first;

                int top = matrix[first][i];//save top
                //left->top
                matrix[first][i] = matrix[last-offset][first];
                //bottom->left
                matrix[last-offset][first] = matrix[last][last-offset];
                //right->bottom
                matrix[last][last-offset] = matrix[i][last];
                //top->right
                matrix[i][last] = top;//right<-saved top
            }
        }
        return true;
    }
    public static void main(String[] args){

        int[][] matrix = AssortedMethods.randomMatrix(5,5,10,1);

        AssortedMethods.printMatrix(matrix);

        rotate(matrix);

        System.out.println();

        AssortedMethods.printMatrix(matrix);
    }
}
