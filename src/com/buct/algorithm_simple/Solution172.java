package com.buct.algorithm_simple;

/**
 * 删除元素
 * 给定一个数组和一个值，在原地删除与值相同的数字，返回新数组的长度。

 元素的顺序可以改变，并且对新的数组不会有影响。
 */
public class Solution172 {
    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        int newLength = A.length;
        int i = 0;
        while (i < newLength) {
            if (A[i] == elem) {
                newLength --;
                // 移位
                for (int j = i+1; j < A.length; j++) {
                    A[j-1] = A[j];
                }

            } else {
                i++;
            }
        }
        return newLength;
    }
    
    
}