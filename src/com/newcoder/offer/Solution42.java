package com.newcoder.offer;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 解题思路
 　　考虑用两个数small 和big 分别表示序列的最小值和最大值。首先把small 初始化为1, big 初始化为2。如果从small 到big 的序列的和大于s，
 我们可以从序列中去掉较小的值，也就是增大small 的值。如果从small 到big 的序列的和小于s，我们可以增大big，让这个序列包含更多的数字。
 因为这个序列至少要有两个数字，我们一直增加small 到(1+s)/2 为止。
 　　以求和为9 的所有连续序列为例，我们先把small 初始化为1, big 初始化为2。此时介于small 和big 之间的序列是｛1，2}，序列的和为3，小于9，所以我们下一步要让序列包含更多的数字。我们把big 增加1 变成3,此时序列为｛ I, 2，坷。由于序列的和是6，仍然小于9，我们接下来再增加big 变成4，介于small 和big 之间的序列也随之变成｛ l, 2, 3, 4｝。由于列的和10 大于9，我们要删去去序列中的一些数字， 于是我们增加small 变成2，此时得到的序列是｛2, 3, 4｝， 序列的和E好是9。
 我们找到了第一个和为9 的连续序列，把它打印出来。接下来我们再增加big，重复前面的过程，可以找到第二个和为9 的连续序列｛4，5}。
 */
public class Solution42 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (sum < 3) {
            return ret;
        }

        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int currSum = small + big;

        while (small < middle) {
            if (currSum == sum) {
                ArrayList<Integer> list = new ArrayList<>(2);
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                ret.add(list);
            }

            while (currSum > sum && small < middle) {
                currSum -= small;
                small++;
                if (currSum == sum) {
                    ArrayList<Integer> list2 = new ArrayList<>();
                    for (int i = small; i <= big; i++) {
                        list2.add(i);
                    }
                    ret.add(list2);
                }
            }

            big++;
            currSum += big;
        }

        return ret;
    }
}