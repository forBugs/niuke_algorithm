package com.buct.algorithm_simple;

/**
 * 不同的路径
 * 有一个机器人的位于一个 m × n 个网格左上角。

 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。

 问有多少条不同的路径？
 *
 */
public class Solution114 {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[m-1][n-1];
    }
}