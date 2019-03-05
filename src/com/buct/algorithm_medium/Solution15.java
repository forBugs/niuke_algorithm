package com.buct.algorithm_medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个数字列表，返回其所有可能的排列。
 *
 *  递归：
 *
 */
public class Solution15 {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        dfs(res, list, nums);
        return res;

    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums) {
        int n = nums.length;
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(res, list, nums);
            list.remove(list.size() - 1);
        }

    }
}