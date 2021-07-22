/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 13/07/2021    1.0            Vanhv           J1.S.P0074
 */

/**
 *
 * @author vanhv
 */
public class Manager {

    Validate v = new Validate();

    int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrixResult = new int[row][col];
        if (row != matrix2.length || col != matrix2[0].length) {
            return null;
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];

                }
            }
        }
        return matrixResult;
    }

    int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrixResult = new int[row][col];
        if (row != matrix2.length || col != matrix2[0].length) {
            return null;
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
        }
        return matrixResult;
    }

    int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        //len of row m1
        int row1 = matrix1.length;
        //Get len col m1 by get len matrix at 0
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int[][] matrixResult = new int[row1][col2];
        if (col1 != row2) {
            return null;
        } else {
            //for row matrix 1 
            for (int i = 0; i < row1; i++) {
                //for col matrix 2
                for (int j = 0; j < col2; j++) {
                    int sum = 0;
                    //for col matrix 1
                    for (int k = 0; k < col1; k++) {
                        //sum = value at [i][k] * [k][j]
                        sum += matrix1[i][k] * matrix2[k][j];
                        //set value to new matrix [i][j]
                        matrixResult[i][j] = sum;
                    }
                }
            }
        }
        return matrixResult;
    }

    void addMatrixManager(int[][] matrix1, int[][] matrix2) {
        System.out.println("------Result------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(additionMatrix(matrix1, matrix2));
    }

    void subMatrixManager(int[][] matrix1, int[][] matrix2) {
        System.out.println("------Result------");
        displayMatrix(matrix1);
        System.out.println("/");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(subtractionMatrix(matrix1, matrix2));
    }

    void multipleMatrixManager(int[][] matrix1, int[][] matrix2) {
        System.out.println("------Result------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(multiplicationMatrix(matrix1, matrix2));
    }

    void displayMatrix(int[][] result) {
        int row = result.length;
        int col = result[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + result[i][j] + "]");
            }
            System.out.println();
        }
    }
}
