package com.buct.algorithm_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 带重复元素的全排列
 */
public class Solution16 {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = 0;
        }
        helper(res,list,visited,nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] visited, int[] nums) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i != 0 && (visited[i - 1] == 0 && nums[i] == nums[i - 1]))) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = 1;
            helper(res, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
};