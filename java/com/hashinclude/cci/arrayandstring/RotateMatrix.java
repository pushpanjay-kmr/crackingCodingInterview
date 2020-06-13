package com.hashinclude.cci.arrayandstring;

/**
 * @author pushpanjay.kumar created on 13/6/20
 */
public class RotateMatrix {

    private static void disp(int[][] matrix){
        System.out.println();
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * TC: O(N^2)
     * AS: O(1); inplace algo
     * @param matrix
     * @return
     */
    private static boolean rotate(int[][] matrix){
        if(matrix.length == 0 || matrix.length!= matrix[0].length){
            return false;
        }
        int n = matrix.length;
        for(int layer = 0; layer<n/2; layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i=first;i<last;i++){
                int offset = i-first;

                int top = matrix[first][i];
                // left->top
                matrix[first][i] = matrix[last-offset][first];
                // bottom->left
                matrix[last-offset][first] = matrix[last][last-offset];
                // right->bottom
                matrix[last][last-offset] = matrix[i][last];
                // top->right
                matrix[i][last] = top;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        disp(matrix);
        if(rotate(matrix)){
            disp(matrix);
        } else{
            System.out.println("Not a square matrix");
        }
    }
}
