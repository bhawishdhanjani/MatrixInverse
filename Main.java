package com.matrixInverse;



public class Main {
    public static void main(String[] args) {
        var console = new Console();
        console.dimensionOfMatrix();
        console.setMatrix();
        var matrixInverse = new MatrixInverse(console.getRows(), console.getColumns(), console.getMatrix());
        double [][] inverseOfMatrix = matrixInverse.inverse();
        var formattedMatrix = new FormatInverse();
        formattedMatrix.formattedResult(inverseOfMatrix);

    }
}
