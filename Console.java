package com.matrixInverse;

import java.util.Scanner;

public class Console {
    private int rows;
    private int columns;
    private double[][] matrix ;
    final private Scanner scanner = new Scanner(System.in);

    public void dimensionOfMatrix(){
        System.out.println("Enter No of Rows");
        rows = scanner.nextInt();
        System.out.println("Enter No of Rows");
        columns = scanner.nextInt();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setMatrix(){
        matrix = new double[rows][columns];
        for (int i = 0 ; i<rows ; i++){
            for (int j = 0 ; j<columns ; j++){
                System.out.format("Enter element having index [%d,%d] \n",i+1,j+1);
                matrix[i][j] = scanner.nextInt();
            }
        }

    }

    public double[][] getMatrix() {
        return matrix;
    }
}
