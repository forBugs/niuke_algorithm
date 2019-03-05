package com.buct.algorithm_simple;

import java.util.Arrays;
import java.util.List;

/**
 * 写一个算法来判断一个数是不是"快乐数"。

 一个数是不是快乐是这么定义的：对于一个正整数，每一次将该数替换为他每个位置上的数字的平方和，
 然后重复这个过程直到这个数变为1，或是无限循环但始终变不到1。如果可以变为1，那么这个数就是快乐数。

 思路：
 我们发现在算到最后时数字4又出现了，那么之后的数字又都会重复之前的顺序，这个循环中不包含1，那么数字11不是一个快乐数，发现了规律后就要考虑怎么用代码来实现，我们可以用set来记录所有出现过的数字，
 然后每出现一个新数字，在set中查找看是否存在，若不存在则加入表中，若存在则跳出循环，并且判断此数是否为1，若为1返回true，不为1返回false，代码如下：
 */
public class Solution488 {
    /**
     * @param n: An integer
     * @return: true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // write your code here
        int sum = getSum(n);
        while (true) {
            if(sum == 1) {
                return true;
            }
            if(sum == 4) {
                return false;
            }
            sum = getSum(sum);
        }
    }

    public static int getSum(int n) {
        int sum = 0;
        int x;
        while (n != 0){
            x = n%10;
            n = n/10;
            sum += x*x;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(16));
    }
}