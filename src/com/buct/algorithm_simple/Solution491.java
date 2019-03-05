package com.buct.algorithm_simple;

/**
 * 回文数：判断一个正整数是不是回文数。

 回文数的定义是，将这个数反转之后，得到的数仍然是同一个数。
 */
public class Solution491 {
    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // write your code here
        long reverse = getReverseNum(num);
        if(reverse == num) {
            return true;
        }
        return false;
    }

    public long getReverseNum(int num) {
        int temp = num;
        long sum = 0;
        while (temp != 0) {

            sum = sum *10 + temp%10;
            temp = temp/10;
        }
        return sum;
    }

}