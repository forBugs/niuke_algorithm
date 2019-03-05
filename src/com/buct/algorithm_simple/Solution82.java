package com.buct.algorithm_simple;

/**
 * 落单的数
 * 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 *  思路：
 *         把数组中所有的数字做异或，因为相同的两个数组异或结果为0，所以最后得到的数字就是结果。
 */
public class Solution82 {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        if (A.length == 0) {
            return 0;
        }
        int current = A[0];
        for (int i = 1; i < A.length; i++) {
            current = current ^ A[i];
        }
        return current;
    }
}