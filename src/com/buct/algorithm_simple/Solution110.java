package com.buct.algorithm_simple;

/**
 * 最小路径和
 * 给定一个只含非负整数的m*n网格，找到一条从左上角到右下角的可以使数字和最小的路径。
 * 思路：使用动态规划，用二维数组 dp[i][j] 表示网格第 i 行、第 j 列元素到右下角的最小路径
 动态转移方程为：dp[i][j] = gird[i][j] + min(dp[i+1][j], dp[i][j+1])
 过程如下图
 */
public class Solution110 {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return  0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] minSum = new int[m][n];
        // 给首个元素赋为值
        minSum[0][0] = grid[0][0];
        //给首行  首列赋值
        for (int i = 1; i < m; i++) {
            minSum[i][0] = minSum[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            minSum[0][i] = minSum[0][i - 1] + grid[0][i];
        }
        // 给剩余元素赋值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                minSum[i][j] = Math.min(minSum[i - 1][j], minSum[i][j - 1]) + grid[i][j];
            }
        }

        return minSum[m - 1][n - 1];
    }
}