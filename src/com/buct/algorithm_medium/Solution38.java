package com.buct.algorithm_medium;

/**
 * 搜索二维矩阵
 */
public class Solution38 {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] > target) {
                break;
            }
            if(matrix[i][0] == target) {
                result ++;
                break;
            }
            if(matrix[i][matrix[i].length - 1] < target) {
                continue;
            }
            if (matrix[i][matrix[i].length - 1] == target) {
                result ++;
                continue;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == target) {
                    result ++;
                }
            }
        }

        return result;
    }
}