package inClass.week8Matrix;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] aux = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                aux[i][j] = matrix[i - 1][j - 1] - '0';
            }
        }
        int maxSquare = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1') {
                    aux[i][j] = Math.min(aux[i][j-1],
                            Math.min(aux[i-1][j], aux[i-1][j-1])) + 1;
                } else {
                    aux[i][j] = 0;
                }
                maxSquare = Math.max(maxSquare, aux[i][j]);
            }
        }

        return maxSquare * maxSquare;

    }
}

/*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.



Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:


Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.
 */