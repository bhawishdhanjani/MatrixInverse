package com.matrixInverse;



public class MatrixInverse {
    final private int rows;
    final private int columns;
    private double[][]  matrix;
    private double[][] matrixInverse ;
    private int[] noOfZerosInRow;

    public MatrixInverse(int rows, int column, double[][] matrix) {
        this.rows = rows;
        this.columns = column;
        this.matrix = matrix;
    }

    private void setMatrixInverse() {
        inverseMatrix();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixInverse[i][j] = 0 ;
            }
            matrixInverse[i][i]=1;
        }
    }

    private int[] noOfZero(){
        noOfZerosInRow = new int [rows];
        for (int i = 0 ; i<rows ; i++){
            for (int j = 0 ; j<columns ; j++){
                if(matrix[i][j]==0)
                    noOfZerosInRow[i]++;
                else break;
            }
        }
        return noOfZerosInRow;
    }
    private double[][] reArrangeMatrix(){
        setMatrixInverse();
        double [][] tempMatrix = new double[rows][columns];
        double [][] tempInverseMatrix = new double[rows][columns];
        for (int i = 0 ; i<rows ; i++){
            for (int j = i+1 ; j<rows ; j++){
                if(noOfZero()[i]>noOfZero()[j]){
                    tempMatrix[i] = matrix[i];
                    matrix[i] = matrix[j];
                    matrix[j] = tempMatrix[i];
                    tempInverseMatrix[i] = matrixInverse[i];
                    matrixInverse[i] = matrixInverse[j];
                    matrixInverse[j] = tempInverseMatrix[i];

                }
            }


        }
        return matrix;
    }

    private double[][] halfInverse(){
        double operation;
        matrix = reArrangeMatrix();
        for (int i =0 ; i<rows-1 ; i++){
            for (int j = 0 ; j<columns ; j++){
                if(!(matrix[i][j]==0)) {
                    for (int l  = i+1 ; l<rows ; l++) {
                        operation = (matrix[l][j] / matrix[i][j]);
                        for (int k = j; k < columns; k++) {
                            matrix[l][k] = matrix[l][k] - (operation * matrix[i][k]);
                        }
                        for (int m = 0 ; m<columns ;m++ ){
                            matrixInverse[l][m] = matrixInverse[l][m] - (operation * matrixInverse[i][m]);
                        }
                    }
                    break;
                }
            }
        }
        return matrix;
    }

    private double[][] matrixFormatter(double[][] anyMatrix){
        for (int i = 0 ; i<rows ; i++){
            for (int j =0 ; j<columns ; j++){
                anyMatrix[i][j] = Math.round(anyMatrix[i][j]*100.0)/100.0;
//                matrixInverse[i][j] = Math.round(matrixInverse[i][j]*100.0)/100.0;
            }
        }
        return anyMatrix;
    }
    private int orderOfMatrix(){
        int orderOfMatrix = rows;
        noOfZerosInRow = noOfZero();
        for (int element:noOfZerosInRow) {
            if(element==columns)
                orderOfMatrix--;
        }
        return orderOfMatrix;
    }
    public double[][] inverse(){

        if(isInversePossible()) {
            matrix = halfInverse();
            double operation;
            for (int i = rows - 1; i > 0; i--) {
                for (int j = 0; j < columns; j++) {
                    if (!(matrix[i][j] == 0)) {
                        for (int l = i - 1; l >= 0; l--) {
                            operation = (matrix[l][j] / matrix[i][j]);
                            for (int k = j; k < columns; k++) {
                                matrix[l][k] = matrix[l][k] - (operation * matrix[i][k]);
                            }
                            for (int m = 0; m < columns; m++) {
                                matrixInverse[l][m] = matrixInverse[l][m] - (operation * matrixInverse[i][m]);
                            }
                        }
                        break;
                    }
                }

            }
            for (int i = 0; i < rows; i++) {
                double leadingElement = 1;
                for (int j = 0; j < columns; j++) {
                    if (!(matrix[i][j] == 0)) {
                        leadingElement = matrix[i][j];

                        break;
                    }
                }
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = matrix[i][j] / leadingElement;
                    matrixInverse[i][j] = matrixInverse[i][j] / leadingElement;
                }
            }
            matrixInverse = matrixFormatter(matrixInverse);
            return matrixInverse;
        }
        else{
            System.out.println("Inverse is Not Possible");
            return null;
        }
    }


    private boolean isInversePossible(){
        return (orderOfMatrix()==rows) && (rows==columns);
    }


    private void inverseMatrix(){
        this.matrixInverse = new double[rows][columns];
    }

}
