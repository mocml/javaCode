
import java.util.Scanner;

/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 13/07/2021    1.0            Vanhv          J1.S.P0074
 */
/**
 *
 * @author vanhv
 */
public class Validate {

    Scanner in = new Scanner(System.in);

    int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }

    }

    int[][] inputMatrix(int order) {
        
        System.out.print("Enter Row Matrix [" + order + "] : ");
        int row = checkIntLimit(1, Integer.MAX_VALUE);
        System.out.print("Enter Colum Matrix [" + order + "] : ");
        int col = checkIntLimit(1, Integer.MAX_VALUE);

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + order + "[" + i + "]" + "[" + j + "] : ");
                matrix[i][j] = checkInputInt();
            }
        }
        System.out.println("\n");
        return matrix;
    }


}
