package com.buct.algorithm_simple;

/**
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。

 你可以假设在数组中无重复元素。
 */
public class Solution60 {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A.length == 0) {
            return 0;
        }
        int i ;
        for (i = A.length -1; i >= 0; i--) {
            if(A[i] == target){
                return i;
            }
            if (A[i] < target) {
                break;
            }
        }
        return i+1;
    }
}