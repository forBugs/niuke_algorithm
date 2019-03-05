package com.buct.algorithm_medium;

import java.util.ArrayList;
import java.util.List;

/**
 *  字符大小写排序
 *  给定一个只包含字母的字符串，按照先小写字母后大写字母的顺序进行排序。
 */
public class Solution49 {
    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here
        List<Character> chars_small = new ArrayList<>();
        List<Character> chars_large = new ArrayList<>();
        for (char aChar : chars) {

            if (aChar >= 97 && aChar <= 122) {
                chars_small.add(aChar);
            } else if (aChar >= 65 && aChar <= 90) {
                chars_large.add(aChar);
            }

        }
        // 合并
        int index = 0;
        for (Character c : chars_small) {
            chars[index++] = c;
        }
        for (Character c : chars_large) {
            chars[index++] = c;
        }


    }

    public static void main(String[] args) {
        System.out.println('c');
    }
}