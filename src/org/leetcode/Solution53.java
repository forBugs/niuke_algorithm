package org.leetcode;

import java.util.Arrays;

/**
 * 最大子数组
 */
class Solution53 {
    public int maxSubArray(int[] nums) {
        //f[i] = f[i-1]<0?f[i] : f[i-1] + nums[i]
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for(int i = 1; i< nums.length; i++) {
            f[i] = Math.max(nums[i],f[i-1]+nums[i]);            
        }

       Arrays.sort(f);
        return f[nums.length-1];
    }

    public int maxSubArray2(int[] nums) {
        // sum = sum <0? nums[i]?sum+nums[i];

        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = sum > maxSum ? sum : maxSum;
        }
        return maxSum;
    }

}