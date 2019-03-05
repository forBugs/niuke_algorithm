package com.newcoder.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中元素个数超过数组长度一般的元素
 */
public class P29 {

    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        // 找到每个元素对应的个数
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i],1);
            } else {
                map.put(array[i],map.get(array[i]) + 1);
            }
        }

        int count = array.length/2;
        for (Integer key : map.keySet()) {
            if (map.get(key) > count) {
                return key;
            }
        }
        return 0;
    }
}

