package com.newcoder.offer;

import java.util.Arrays;

/**
 * 扑克牌顺子
 */
public class Solution46 {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0) {
            return false;
        }

        // 先排序
        Arrays.sort(numbers);

        // 获取numbers中0的个数
        int count0 = 0;
        for (int number : numbers) {
            count0 = (number == 0) ? (count0 + 1) : count0;
        }

        // 找到第一个非零数字对应的序号
        int indexNot0 = -1;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > 0) {
                indexNot0 = i;
                break;
            }
        }

        // 统计不连续的数字个数
        int countNotContinuous = 0;
        if(indexNot0 >= 0) {
            for (int i = indexNot0; i < numbers.length-1; i++) {
                if (numbers[i] == numbers[i + 1]) {
                    return false;
                } else if (numbers[i + 1] > numbers[i]) {
                    countNotContinuous += (numbers[i + 1] - numbers[i] - 1);
                } else {

                }
            }
        }

        return count0 <= countNotContinuous;

    }
}