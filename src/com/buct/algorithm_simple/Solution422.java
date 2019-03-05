package com.buct.algorithm_simple;

/**
 * 最后一个单词的长度
 * 给定一个字符串， 包含大小写字母、空格' '，请返回其最后一个单词的长度。

 如果不存在最后一个单词，请返回 0 。
 */
public class Solution422 {
    /**
     * @param s: A string
     * @return: the length of last word
     */
    public int lengthOfLastWord(String s) {
        // write your code here
        int tlen = 0;
        int lastLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' '){
                tlen ++;
            } else {
                lastLen = tlen;
                tlen = 0;
            }
        }

        if(tlen != 0){
            lastLen = tlen;
        }
        return lastLen;
    }
}