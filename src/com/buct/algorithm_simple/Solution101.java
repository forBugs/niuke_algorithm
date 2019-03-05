package com.buct.algorithm_simple;

/**
 * 删除排序数组中的重复数字 II
 * 跟进“删除重复数字”：

 如果可以允许出现两次重复将如何处理？
 */
public class Solution101 {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int fast = 1,slow = 1;
        int count = 1; //当前元素的重复计数
        for (; fast < nums.length; fast++) {
            if(nums[fast] == nums[fast-1]) {
                if(count==1) {
                    count++;
                    nums[slow++] = nums[fast];
                }
            } else {
                nums[slow++] = nums[fast];
                count = 1;
            }
        }
        return slow;
    }
}