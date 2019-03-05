package com.buct.algorithm_medium;

/**
 * 最长公共前缀
 * 给k个字符串，求出他们的最长公共前缀(LCP)
 */
public class Solution78 {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return null;
        }
        // 找到长度最短的一个字符串
        int length = strs[0].length();
        int minIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < length) {
                length = strs[i].length();
                minIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder("");
        String base_str = strs[minIndex];
        char[] chars = base_str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (isExists(c, i,strs)) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    // 判断一个字符是否在所有的字符串数组中存在
    boolean isExists(char c,int i, String[] strs) {
        for (String str : strs) {
            if(!str.contains(""+c) || str.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }
}