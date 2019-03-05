package com.newcoder.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution38 {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i : array) {
            count = (i == k)? count + 1:count;
        }
        return count;
    }
}