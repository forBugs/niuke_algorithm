package com.newcoder.offer;

/**
 * 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 第二种：创建数组保存已经找到丑数，用空间换时间的解法。

 根据丑数的定义， 丑数应该是另一个丑数乘以2、3 或者5 的结果（1除外）。因此我们可以创建一个数组，里面的数字是排好序的丑数，每一个丑数都是前面的丑数乘以2、3或者5得到的。

 这种思路的关键在于怎样确保数组里面的丑数是排好序的。假设数组中已经有若干个丑数排好序后存放在数组中，并且把己有最大的丑数记做M，我们接下来分析如何生成下一个丑数。该丑数肯定是前面某一个丑数乘以2、3 或者5 的结果， 所以我们首先考虑把已有的每个丑数乘以2。在乘以2 的时钝能得到若干个小于或等于M 的结果。由于是按照顺序生成的，小于或者等于M 肯定己经在数组中了，我们不需再次考虑：还会得到若干个大于M 的结果，但我们只需要第一个大于M 的结果，因为我们希望丑数是按从小到大的顺序生成的，其他更大的结果以后再说。我们把得到的第一个乘以2 后大于M 的结果记为M2，同样，我们把已有的每一个丑数乘以3 和5，能得到第一个大于M 的结果M3 和M，那么下一个丑数应该是M2、M3 和M5这3个数的最小者。

 前面分析的时候，提到把已有的每个丑数分别都乘以2、3 和5。事实上这不是必须的，因为已有的丑数是按顺序存放在数组中的。对乘以2而言， 肯定存在某一个丑数T2，排在它之前的每一个丑数乘以2 得到的结果都会小于已有最大的丑数，在它之后的每一个丑数乘以2 得到的结果都会太大。我们只需记下这个丑数的位置， 同时每次生成新的丑数的时候，去更新这个T2。对乘以3 和5 而言， 也存在着同样的T3和T5。

 本题实现了两种方法
 */
public class P34 {

    public static int GetUglyNumber_Solution(int index) {

        if (index < 7) {
            return index;
        }
        int nextIndex = 1;
        int[] uglyArrs = new int[index];
        uglyArrs[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int min;
        while (nextIndex < index) {
            min = Math.min(Math.min(uglyArrs[p2] * 2, uglyArrs[p3] * 3), uglyArrs[p5] * 5);
            uglyArrs[nextIndex] = min;
            while (uglyArrs[p2] * 2 <= uglyArrs[nextIndex]) {
                p2++;
            }

            while (uglyArrs[p3] * 3 <= uglyArrs[nextIndex]) {
                p3++;
            }
            System.out.println(p5);
            while (uglyArrs[p5] * 5 <= uglyArrs[nextIndex]) {
                p5++;
            }

        }
        return uglyArrs[index - 1];
    }


    public static int GetUglyNumber_Solution2(int index) {
        if(index<7) return index;
        int[] ret = new int[index];
        ret[0]=1;
        int t2=0,t3=0,t5=0;
        for(int i=1;i<index;i++) {
            ret[i] = Math.min(Math.min(ret[t2]*2,ret[t3]*3),ret[t5]*5);
            if(ret[i] == ret[t2]*2) t2++;
            if(ret[i] == ret[t3]*3) t3++;
            if(ret[i] == ret[t5]*5) t5++;
        }
        return ret[index-1];
    }

    /**
     * 判断一个数是否是丑数
     * @param num
     * @return
     */
    public boolean isUgly(int num) {

        while (num %2 == 0) {
            num /= 2;
        }
        while (num %3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution2(8));
    }
}
