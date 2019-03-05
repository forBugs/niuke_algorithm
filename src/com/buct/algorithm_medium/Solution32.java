package com.buct.algorithm_medium;

import java.util.HashMap;

/**
 * 给定一个字符串source和一个目标字符串target，在字符串source中找到包括所有目标字符串字母的子串。
 * 思路：
 *
 */
public class Solution32 {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here
        int s = source.length();
        int t = target.length();
        String result = "";
        HashMap<Character, Integer> tar = new HashMap<>();
        for (int i = 0; i < t; i++) {
            char ta = target.charAt(i);
            if (tar.containsKey(ta)) {
                tar.put(ta, tar.get(ta) + 1);
            } else {
                tar.put(ta, 1);
            }
        }

        HashMap<Character, Integer> record = new HashMap<>();
        int count = 0;
        int right = 0;
        boolean change = false;
        for (int i = 0; i < s; i++) {
            char so = source.charAt(i);
            if (record.containsKey(so)) {
                record.put(so,record.get(so) +1);
                if(tar.containsKey(so) &&tar.get(so) >= record.get(so)) {
                    count ++;
                }
            } else {
                record.put(so, 1);
                if(tar.containsKey(so) && tar.get(so) >= record.get(so)) {
                    count++;
                }
            }
            if (count == t) {
                right = i;
                change = true;
                break;
            }
        }
        if (change) {
            result = source.substring(0, right + 1);
            int left = 0;
            char m = result.charAt(left);
            while (!tar.containsKey(m) || record.get(m) > tar.get(m)) {
                if (tar.containsKey(m) && record.get(m) > tar.get(m)) {
                    record.put(m,record.get(m) - 1);
                }
                left ++;
                m = result.charAt(left);
            }
            result = result.substring(left);
        }
        return result;
    }
}