package com.buct.algorithm_simple;

/**
 * 数字三角形
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
 */
public class Solution109{
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0 || triangle[0] == null || triangle[0].length == 0) {
            return 0;
        }
        if (triangle.length == 1) {
            return triangle[0][0];
        }
        for(int i = triangle.length - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                triangle[i][j] += Math.min(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0];
    }
}