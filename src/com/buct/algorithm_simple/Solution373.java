package com.buct.algorithm_simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 奇偶分割数组
 * 分割一个整数数组，使得奇数在前偶数在后。
 */
public class Solution373 {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        // 先拆分
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evens.add(nums[i]);
            } else {
                odds.add(nums[i]);
            }
        }
        int index = 0;
        // 奇数在前 偶数在后 组合合并到nums数组中
        for (Integer odd : odds) {
            nums[index++] = odd;
        }
        for (Integer even : evens) {
            nums[index++] = even;
        }
    }
}