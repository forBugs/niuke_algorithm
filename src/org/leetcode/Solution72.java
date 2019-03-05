package org.leetcode;

import java.util.Arrays;

class Solution72 {
    // 记忆数组
    int[][] records;

    public int minDistance(String word1, String word2) {
        // 记忆话递归
        int l1 = word1.length();
        int l2 = word2.length();
        records = new int[l1 + 1][l2 + 1];
        for (int[] record : records) {
            Arrays.fill(record, -1);
        }
        return minDistance(word1, word2, l1, l2);
    }

    // minDistance from word1[0.....i-1] to word2[1.....j-1]
    int minDistance(String word1, String word2, int i, int j) {
        // records[i][j] = minDistance
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        int ans;
        if (records[i][j] > 0)
            return records[i][j];
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return minDistance(word1, word2, i - 1, j - 1);
        }
        records[i][j] = Math.min(Math.min(minDistance(word1, word2, i - 1, j), minDistance(word1, word2, i - 1, j - 1)),
                minDistance(word1, word2, i, j - 1)) + 1;
        return records[i][j];
    }


    // 动态规划法
    public int minDistance2(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        // dp[i][j] 代表minDistance from word1[0...i-1]   to word2[0.....j-1]
        int[][] dp = new int[l1 + 1][l2 + 1];
        // 处理边界条件
//        dp[0][0] = 1;
        for (int i = 0; i < l1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < l2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }

            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        int[] arrs = new int[10];
        Arrays.fill(arrs, -1);
        System.out.println(Arrays.toString(arrs));
    }
}