package org.leetcode;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        // 首先给第一行和第一列赋值为1   如果由障碍物  赋值为0
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) {
                continue;
            }
            dp[i][0] = 1;
        }

        for (int i = 0; i < cols; i++) {
            if (obstacleGrid[0][i] == 1) {
                continue;
            }
            dp[0][i] = 1;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }

        }
        return dp[rows - 1][cols - 1];

    }

}