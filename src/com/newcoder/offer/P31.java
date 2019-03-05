package com.newcoder.offer;

/**
 * 连续子数组的最大和
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */

/**
 * 解法一：举例分析数组的规律。

 我们试着从头到尾逐个累加示例数组中的每个数字。初始化和为0。第一步加上第一个数字1， 此时和为1。接下来第二步加上数字-2，和就变成了-1。第三步刷上数字3。我们注意到由于此前累计的和是－1 ，小于0，那如果用-1 加上3 ，得到的和是2 ， 比3 本身还小。也就是说从第一个数字开始的子数组的和会小于从第三个数字开始的子数组的和。因此我们不用考虑从第一个数字开始的子数组，之前累计的和也被抛弃。

 我们从第三个数字重新开始累加，此时得到的和是3 。接下来第四步加10，得到和为13 。第五步加上-4， 和为9。我们发现由于-4 是一个负数，因此累加-4 之后得到的和比原来的和还要小。因此我们要把之前得到的和13 保存下来，它有可能是最大的子数组的和。第六步加上数字.7，9 加7 的结果是16，此时和比之前最大的和13 还要大， 把最大的子数组的和由13更新为16。第七步加上2，累加得到的和为18，同时我们也要更新最大子数组的和。第八步加上最后一个数字-5，由于得到的和为13 ，小于此前最大的和18，因此最终最大的子数组的和为18 ，对应的子数组是｛3, 10, -4, 7, 2｝。

 解法二： 应用动态归划法。

 可以用动态规划的思想来分析这个问题。如果用函数f(i)表示以第i个数字结尾的子数组的最大和，那么我们需要求出max[f(i)]，其中0 <= i < n。我们可用如下边归公式求f(i):


 */
public class P31 {

    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i : array) {
            if (curSum <= 0) {
                curSum = i;
            } else {
                curSum += i;
            }

            if (maxSum > curSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }

    /**
     使用动态规划
     F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变

     F（i）=max（F（i-1）+array[i] ， array[i]）

     res：所有子数组的和的最大值

     res=max（res，F（i））





     如数组[6, -3, -2, 7, -15, 1, 2, 2]

     初始状态：

     F（0）=6

     res=6

     i=1：

     F（1）=max（F（0）-3，-3）=max（6-3，3）=3

     res=max（F（1），res）=max（3，6）=6

     i=2：

     F（2）=max（F（1）-2，-2）=max（3-2，-2）=1

     res=max（F（2），res）=max（1，6）=6

     i=3：

     F（3）=max（F（2）+7，7）=max（1+7，7）=8

     res=max（F（2），res）=max（8，6）=8

     i=4：

     F（4）=max（F（3）-15，-15）=max（8-15，-15）=-7

     res=max（F（4），res）=max（-7，8）=8

     以此类推

     最终res的值为8
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        int res = array[0];
        //  即上面的F(i)
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(res,max);
        }
        return res;
    }


    }
