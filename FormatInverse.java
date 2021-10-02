package com.matrixInverse;

public class FormatInverse {
    public void formattedResult(double [][] matrix){
        System.out.println("Inverse Of Matrix");
        System.out.println("_________________");
        for (int i =0 ; i<matrix.length ; i++){
            for (int j = 0 ; j<matrix.length ; j++ ){
                System.out.print(matrix[i][j]);
                System.out.print("    ");
            }
            System.out.println();
        }

    }
}
