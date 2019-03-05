package com.buct.algorithm_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 带重复元素的子集
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集
 */
public class Solution18 {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        Arrays.sort(nums);
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
        }
        dfs(result, item,0, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> item, int start, int[] nums) {
        //
        result.add(new ArrayList<>(item));
        for (int i = start; i < nums.length; i++) {
            // 去重
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            item.add(nums[i]);
            dfs(result,item,i+1,nums);
            item.remove(item.size() - 1);
        }
    }
}