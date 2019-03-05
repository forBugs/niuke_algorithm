package com.newcoder.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 */
public class P35 {

    public static  int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }


        }
        int j = 0;
        for (; j < str.length(); j++) {
            char c = str.charAt(j);
            System.out.println(c+""+map.get(c));
            if (map.get(c) == 1) {
                return j;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar("google");
    }
}
