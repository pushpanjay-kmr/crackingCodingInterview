package com.hashinclude.cci.practice;

/**
 * @author pushpanjay.kumar created on 13/6/20
 */
public class PrintMatrixSpiralOrder {
    private static void printSpiralOrder(int[][] matrix){
        System.out.println();
        if(matrix.length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0;
        int c = 0;
        while(r<m && c<n){
            for(int k=c;k<n;k++){
                System.out.print(matrix[r][k] + " ");
            }
            r++;

            for (int k=r;k<m;k++){
                System.out.print(matrix[k][n-1] + " ");
            }
            n--;

            for(int k=n-1;k>=c;k--){
                System.out.print(matrix[m-1][k] + " ");
            }
            m--;

            for(int k=m-1;k>=r;k--){
                System.out.print(matrix[k][c] + " ");
            }
            c++;
            System.out.println();
        }
    }

    private static void disp(int[][] matrix){
        System.out.println();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        disp(matrix);
        printSpiralOrder(matrix);
    }
}
