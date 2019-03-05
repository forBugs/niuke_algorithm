package com.buct.algorithm_medium;

import java.util.Arrays;

/**
 *背包问题
 */
public class Solution79 {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }
        int lenA = A.length();
        int lenB = B.length();
        int longest = 0;
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {

                int m = i;
                int n = j;
                int longtemp = 0;
                while (m < lenA && n < lenB) {
                    if (A.charAt(m) == B.charAt(n)) {
                        m++;
                        n++;
                        longtemp++;
                    } else {
                        break;
                    }
                }
                longest = Math.max(longest, longtemp);
            }
        }
        return longest;
    }


    /**
     * 上面博客中给了第一种动态规划的解法
     * <p>
     * 定义数组C[lenA+1][lenB+1] C[i][j] 表示字符串A 以A[i-1] 结束 B以B[j-1] 最大相同子串的长度
     * <p>
     * 当A[i-1] ==B[j-1] 的时候 C[i][j] = C[i-1][j-1] + 1 理解了子串的定义就很显然的，”连续字符串“
     * <p>
     * 当A[i-1] !=B[j-1] 的时候  C[i][j] = 0
     * <p>
     * 数组中的最大值就是答案了
     *
     * @param A
     * @param B
     * @return
     */
    public int longestCommonSubstring2(String A, String B) {
        // write your code here
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }
        int lenA = A.length();
        int lenB = B.length();
        int longest = 0;
        int[][] c = new int[lenA + 1][lenB + 1];
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                char ch1 = A.charAt(i - 1);
                char ch2 = B.charAt(j - 1);
                if (ch1 == ch2) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = 0;
                }
                longest = Math.max(longest, c[i][j]);
            }
        }
        return longest;
    }



}