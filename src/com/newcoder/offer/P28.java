package com.newcoder.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class P28 {

    /**
     * 回溯法解决全排列
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str != null && str.length() > 0) {
            permutationHelper(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return res;
    }

    public void permutationHelper(char[] cs,int i,ArrayList<String> res) {
        if(i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!res.contains(val)) {
                res.add(val);
            }
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                // 进一步向下试探
                permutationHelper(cs, i + 1, res);
                // 向上回溯到上一步的状态
                swap(cs, j, i);
            }
        }

    }

    private void swap(char[] arrs, int i, int j) {
        char temp = arrs[i];
        arrs[j] = arrs[i];
        arrs[i] = temp;
    }
}
