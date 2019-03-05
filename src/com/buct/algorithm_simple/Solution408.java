package com.buct.algorithm_simple;

/**
 * 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）
 * 思路：
 *      分别遍历两个字符串  计算指定位数上的和 并考虑进位
 *      /*和求两个链表的和很类似

 考虑进位，考虑最后一项的进位

 0+0 = 0 不需要进位

 0+1 = 1 不需要进位

 1+1 =0  进位 1

 同时注意

 低位进1，高位时1+1的情况，直接加就是3了，这个需要进位1 ，原位的结果也是1的情况
 */
public class Solution408 {
    /**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int sum = 0;
        String result = "";
        while (aLen >= 0 || bLen >= 0) {
            if (aLen >= 0) {
                sum += Integer.valueOf(a.substring(aLen,aLen+1));
                aLen --;
            }
            if (bLen >= 0) {
                sum += Integer.valueOf(b.substring(bLen, bLen + 1));
                bLen --;
            }

            // 根据sum的值  判断进位情况
            if (sum == 2) {
                // 需要进位
                result = "0" + result;
                sum = 1;
            } else if (sum == 0 || sum == 1) {
                result = sum+""+result;
                sum = 0;
            } else if (sum == 3) {
                // 需要进位
                result = "1" + result;
                sum = 1;
            }
        }
        // 判断最后一位是否有进位
        if (sum == 1) {
            result = "1" + result;
        }
        return  result;
    }
}