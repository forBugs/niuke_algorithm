package com.buct.algorithm_medium;

/**
 * 背包问题

 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]

 样例


 如果有4个物品[2, 3, 5, 7]

 如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。

 如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。

 函数需要返回最多能装满的空间大小。

 */
public class Solution92 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int[][] p = new int[A.length+1][m+1];
        for (int i = 1; i < A.length; i++) {
            for (int j = m; j >=0 ; j--) {
                if(j >= A[i-1]) {
                    p[i][j] = p[i-1][j-A[i-1]]+A[i-1];
                }
                p[i][j] = Math.max(p[i-1][j],p[i][j]);
            }
        }
        return p[A.length][m];
    }
}