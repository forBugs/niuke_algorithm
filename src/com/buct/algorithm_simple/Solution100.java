package com.buct.algorithm_simple;

/**
 * 删除排序数组中的重复数字
 * 给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。

 不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。
 */
public class Solution100 {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums==null || nums.length==0){
            return 0;
        }
        int fast = 1,slow = 1;

        while (fast < nums.length) {
            // 找到最后一个当前的数
            while (fast < nums.length && nums[fast] == nums[fast - 1]) {
                fast++;
            }
            if(fast == nums.length)
                break;
            nums[slow++] = nums[fast++];
        }
        return slow;
    }
}