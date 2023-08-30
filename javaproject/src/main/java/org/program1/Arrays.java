package org.program1;

public class Arrays {
    public static void main(String[] args){
        String[] cars = {"Tata","Mahindra","Maruti"};
        for (String car : cars){
            System.out.println("Cars: "+car);
        }
        //multi dimensional arrays
        int[][] matrix = {{1,2,3,4},{5,6,7,8}};
        for (int i =0; i<=matrix.length;i++){
            for (int j =0; j < matrix[i].length;j++){
                System.out.println(matrix[i][j]+" ");
            }
            System.out.println();
        }
        int[] num = {1,3,5,6};

    }



}

