package com.buct.algorithm_simple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主元素
 * 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 */
public class Solution46 {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer num : nums) {
            if (!countMap.containsKey(num)) {
                countMap.put(num, 1);
            } else {
                Integer count = countMap.get(num);
                countMap.put(num,count+1);
            }
        }
        for (Integer num : countMap.keySet()) {
            if (countMap.get(num) > nums.size() / 2) {
                return num;
            }
        }
        return 0;
    }
}