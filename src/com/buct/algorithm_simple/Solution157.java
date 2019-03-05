package com.buct.algorithm_simple;

/**
 * 判断字符串是否没有重复字符
 * 实现一个算法确定字符串中的字符是否均唯一出现
 *
 */
public class Solution157 {
    /*
     * @param str: A string
     * @return: a boolean
     */
    public boolean isUnique(String str) {


        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == temp && j!=i) {
                    return false;
                }
            }
        }
        return true;
    }
}