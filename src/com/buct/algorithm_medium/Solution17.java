package com.buct.algorithm_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 * 给定一个含不同整数的集合，返回其所有的子集
 */
public class Solution17 {

    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<>();
        if(nums == null) {
            return null;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            item.clear();
            dfs(nums,0,i,item,result);
        }

        return result;
    }

    private void dfs(int[] nums, int start, int size, ArrayList<Integer> item, List<List<Integer>> result) {
        if (item.size() == size) {
            result.add(new ArrayList<>(item));
            return ;
        }
        for (int i = start; i < nums.length; i++) {
            item.add(nums[i]);
            dfs(nums, i + 1, size, item, result);
            item.remove(item.size() - 1);
        }
    }


}
