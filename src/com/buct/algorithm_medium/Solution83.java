package com.buct.algorithm_medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 落单的数 II
 给出3*n + 1 个的数字，除其中一个数字之外其他每个数字均出现三次，找到这个数字。

 */
public class Solution83 {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumberII(int[] A) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if(map.containsKey(A[i])) {
                map.put(A[i],map.get(A[i])+1);
            } else {
                map.put(A[i],1);
            }
            if(map.get(A[i]) == 3) {
                map.remove(A[i]);
            }
        }
        int single = 0;
        for (Integer integer : map.keySet()) {
            single = integer;
        }
        return single;
    }
}