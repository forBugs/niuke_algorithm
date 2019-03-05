package org.leetcode;

public class Solution62 {

    int[][] records;

    public int uniquePaths(int m, int n) {
        records = new int[m][n];
        // 记忆化递归
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }

        if (records[m][n] > 0) {
            return records[m][n];
        }

        int left_paths = uniquePaths(m - 1, n);
        int top_paths = uniquePaths(m, n - 1);

        records[m][n] = left_paths + top_paths;
        return records[m][n];
    }

    public int uniquePaths2(int m, int n) {

        // 使用动态规划法
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

        }
        return dp[m - 1][n - 1];
    }


}