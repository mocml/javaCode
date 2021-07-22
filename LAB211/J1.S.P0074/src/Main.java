/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 13/07/2021    1.0            Vanhv   
 */

/**
 *
 * @author vanhv
 */
public class Main {

    public static void main(String[] args) {

        Validate v = new Validate();
        Manager manager = new Manager();
        int[][] matrix1;
        int[][] matrix2;
        while (true) {
            System.out.println("=======Calculator program=======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = v.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    System.out.println("------Addition------");
                    matrix1 = v.inputMatrix(1);
                    matrix2 = v.inputMatrix(2);
                    manager.addMatrixManager(matrix1, matrix2);
                    break;
                case 2:
                    System.out.println("------Subtraction------");
                    matrix1 = v.inputMatrix(1);
                    matrix2 = v.inputMatrix(2);
                    manager.subMatrixManager(matrix1, matrix2);
                    break;
                case 3:
                    System.out.println("------Multiply------");
                    matrix1 = v.inputMatrix(1);
                    matrix2 = v.inputMatrix(2);
                    manager.multipleMatrixManager(matrix1, matrix2);
                    break;
                case 4:
                    return;
            }
        }
    }
}
