package com.buct.algorithm_medium;

/**
 * 61. 搜索区间
 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。

 如果目标值不在数组中，则返回[-1, -1]

 思路：二分法查找  正常解法是二分法分别找左右边界的，时间复杂度O(logN),但是要注意边界，边界很多种情况的。
 */
public class Solution61 {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = {-1,-1};
        if (A == null || A.length == 0) {
            return res;
        }
        int len = A.length;
        res[0] = findLeftIndex(A,0,len-1,target);
        res[1] = findRightIndex(A, 0, len - 1, target);
        return res;
    }

    private int findLeftIndex(int[] nums, int left, int right, int target) {
        if(nums[0] == target)
            return 0;
        while(left <= right){
            int median = (left + right)/2;
            if(nums[median] < target){
                left = median+1;
            }else if(nums[median]>target){
                right = median -1;
            }else if(nums[median]==target){
                if(nums[median-1]!=target)
                    return median;
                else
                    right = median - 1;
            }
        }
        return -1;

    }

    private int findRightIndex(int[] nums, int left, int right, int target) {
        if(nums[right] == target)
            return right;
        while(left <= right){
            int median = (left + right)/2;
            if(nums[median] < target){
                left = median+1;
            }else if(nums[median]>target){
                right = median -1;
            }else if(nums[median]==target){
                if(nums[median+1]!=target)
                    return median;
                else
                    left = median + 1;
            }
        }
        return -1;
    }
}