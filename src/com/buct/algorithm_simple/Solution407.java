package com.buct.algorithm_simple;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 加一
 *给定一个非负数，表示一个数字数组，在该数的基础上+1，返回一个新的数组。

 该数字按照数位高低进行排列，最高位的数在列表的最前面。

 思路：
        如果数组的最后一位不是9的话，那么直接最后一位自身增加1返回数组即可；
        如果碰到是9的情况，则需要考虑进位的情况，从后往前遍历循环，如果为为9则赋值为0，前一位加1，如果不为9则加一返回，或者循环结束，
        如果循环结束还没有return，则可以判断每位都是9，则可以全赋值为0，前面增加一个1
 */
public class Solution407 {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here
        int n = digits.length;
        for (int i = n-1; i >=0 ; i--) {
            if(digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        // 创建一个新数组
        int[] result = new int[n+1];
        result[0] = 1;
        return result;

    }

    @Test
    public void test() {
        int[] nums = {0};
//        plusOne(nums);
        System.out.println(Integer.valueOf("1"));
    }
}