package com.buct.algorithm_simple;

import java.util.Stack;

/**
 * 反转整数
 * 将一个整数中的数字进行颠倒，当颠倒后的整数溢出时，返回 0 (标记为 32 位整数)。
 */
public class Solution413 {
    /**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        // write your code here
        String val_str = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (int i = val_str.length() -1 ; i >= 0; i--) {
            char c = val_str.charAt(i);
            if(c != '-'){
                sb.append(val_str.charAt(i));
            }
        }
        Long aLong = Long.valueOf(sb.toString());
        if (aLong > Integer.MAX_VALUE) {
            return 0;
        }
        return  n>=0?aLong.intValue():(0 - aLong.intValue());
    }
}