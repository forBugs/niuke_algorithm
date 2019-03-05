package com.newcoder.offer;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 思路：
 *      　我们先在数组中选择两个数字，如果它们的和等于输入的s，我们就找到了要找的两个数字。如果和小于s 呢？我们希望两个数字的和再大一点。
 *      由于数组已经排好序了，我们可以考虑选择较小的数字后面的数字。因为排在后面的数字要大一些，那么两个数字的和也要大一些，
 *      就有可能等于输入的数字s 了。
 *      同样， 当两个数字的和大于输入的数字的时候，我们可以选择较大数字前面的数字，因为排在数组前面的数字要小一些。
 */
public class Solution43 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int first = 0;
        int second = array.length - 1;
        long currSum = 0;

        while (first < second) {
            currSum = array[first] + array[second];
            if (currSum == sum) {
                list.add(array[first]);
                list.add(array[second]);
                break;
            } else if (currSum < sum) {
                first++;
            } else {
                second--;
            }

        }

        return list;
    }
}