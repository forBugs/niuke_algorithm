package com.buct.algorithm_simple;

/**
 * 有效回文串
 * 给定一个字符串，判断其是否为一个回文串。只包含字母和数字，忽略大小写。
 */
public class Solution415 {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        return s.matches("[A-Za-z0-9]");
    }
}