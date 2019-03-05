package org.leetcode;

class Solution70 {
    public int climbStairs(int n) {

        // 使用一维动态规划法   递推法
        //  f[0] = 1  f[1]=1  f[i]=f[i-1] + f[i-2]
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public int climbStairs2(int n) {
        // 使用普通递归法
        if (n <= 1) {
            return 1;
        }

        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    // 记忆化递归的记录数组
    int[] records;

    public int climbStairs3(int n) {
        // 使用普通递归法   记忆化递归
        records = new int[n + 1];

        return numOfSolutions(n);

    }

    int numOfSolutions(int n) {
        if (n <= 1) {
            return 1;
        }
        if (records[n] > 0)
            return records[n];
        records[n] = numOfSolutions(n - 1) + numOfSolutions(n - 2);
        return records[n];

    }


    public int climbStairs4(int n) {
        // 使用记忆话递归  但是空间复杂度为2  只用one  和  two  两个变量
        int one = 1;
        int two = 1;
        int current = 1;
        if(n<=1)
            return current;
        for (int i = 2; i <= n ; i++) {
            current = one + two;
            two = one;
            one = current;
        }
        return current;
    }


}