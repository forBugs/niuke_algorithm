package com.buct.algorithm_medium;

import java.util.Set;

/**
 * 107. 单词拆分 I
 给出一个字符串s和一个词典，判断字符串s是否可以被空格切分成一个或多个出现在字典中的单词。

 样例
 给出

 s = "lintcode"

 dict = ["lint","code"]

 返回 true 因为"lintcode"可以被空格切分成"lint code"
 */
public class Solution107 {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        if((s==null ||s.length() ==0) && (dict == null || dict.size()==0))
            return true;
        return wordBreak(s,dict,0);
    }
    public boolean wordBreak(String s,Set<String> dict,int start){
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if(!dp[i])
                continue;
            for (String t : dict) {
                int len = t.length();
                int end = i + len;
                if(end > s.length())
                    continue;
                if(s.substring(i,end).equals(t))
                    dp[end] = true;
            }
        }
        return dp[s.length()];
    }

}