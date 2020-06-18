package com.hashinclude.cci.arrayandstring;

/**
 * @author pushpanjay.kumar created on 13/6/20
 */
public class ZeroMatrix {

    private static void disp(int[][] matrix){
        System.out.println();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setZeros(int[][] matrix){
        boolean hasZeroInFirstRow = false;
        boolean hasZeroInFirstColumn = false;
        int m = matrix.length;
        int n = matrix[0].length;

        for(int j=0;j<n;j++){
            if(matrix[0][j] == 0){
                hasZeroInFirstRow = true;
                break;
            }
        }

        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0){
                hasZeroInFirstColumn = true;
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0){
                setRowZero(matrix, i);
            }
        }

        for(int j=0;j<n;j++){
            if(matrix[0][j] == 0){
                setColumnZero(matrix, j);
            }
        }

        if (hasZeroInFirstRow){
            setRowZero(matrix, 0);
        }

        if (hasZeroInFirstColumn){
            setColumnZero(matrix, 0);
        }
    }

    private static void setRowZero(int[][] matrix, int i){
        for(int j=0;j<matrix[0].length;j++){
            matrix[i][j] = 0;
        }
    }

    private static void setColumnZero(int[][] matrix, int j){
        for(int i=0;i<matrix.length;i++){
            matrix[i][j] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 0, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {0, 18, 19, 20}};
        disp(matrix);
        setZeros(matrix);
        disp(matrix);
    }
}
