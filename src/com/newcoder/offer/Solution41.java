package com.newcoder.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution41 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        int index = 0;
        for (Integer k : map.keySet()) {
            if(map.get(k) == 1 && index == 0) {
                num1[0] = k;
                index ++;
            } else if (map.get(k) == 1 && index == 1){
                num2[0] = k;
            }
        }
    }
}