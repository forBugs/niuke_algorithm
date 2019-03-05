package com.newcoder.offer;

/**
 * 翻转单词顺序列
 *
 */
public class Solution45 {
    public String ReverseSentence(String str) {
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int pre = 0;
        int nextBlank = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ') {
                nextBlank = i;
                reverse(arr, pre, nextBlank - 1);
                pre = nextBlank + 1;
            }
        }

        // 翻转最后一个空格
        reverse(arr, pre, arr.length - 1);

        return new String(arr);
    }

    public void reverse(char[] arrs, int start, int end) {

        while (start < end) {
            char c = arrs[start];
            arrs[start] = arrs[end];
            arrs[end] = c;

            start++;
            end--;

        }
    }
}