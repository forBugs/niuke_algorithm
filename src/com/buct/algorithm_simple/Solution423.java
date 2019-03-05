package com.buct.algorithm_simple;

import java.util.Stack;

/**
 * 有效的括号序列
 * 给定一个字符串所表示的括号序列，
 * 包含以下字符： '(', ')', '{', '}', '[' and ']'， 判定是否是有效的括号序列。
 * <p>
 * 思路：
 * 思路分析：
 * 首先我们需要知道，此题只是让我们判断括号序列是否合法，不是表达式是否合法，因此我们就假定只有括号，或者说我们只考虑括号，不考虑其他的字符。
 * 其次，我们知道括号是否有效：
 * 第一，括号要成对出现，例如出现左圆括号（'('）n次，则右圆括号（')'）也必须出现n次，对于方括号和花括号也是一样的；
 * 第二，括号可以嵌套，但是从里到外一定是满足可以成对抵消的，而不能够是错开的，这个从样例就可以看出来。
 * <p>
 * 那么我的思路就是借用栈这个数据结构来解此题。
 * 1. 遇到左括号，全部压入栈中；
 * 2. 遇到右括号，判断栈顶的元素是否是相对应的左括号，若是则弹出栈顶元素，若不是则返回false，若栈为空，也返回false；
 */
public class Solution423 {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(whatParent(c) < 0){
                stack.push(c);
            }
            if(whatParent(c) > 0) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character pop = stack.lastElement();
                    if (whatParent(pop) + whatParent(c) == 0) {
                        // 出栈
                        stack.pop();
                    } else {
                        return false;
                    }

                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }

    // 给特定的括号设置数字标志  用来判断成对
    int whatParent(char c) {
        switch (c) {
            case '(':
                return -1;
            case '[':
                return -2;
            case '{':
                return -3;
            case ')':
                return 1;
            case ']':
                return 2;
            case '}':
                return 3;
            default:
                return 0;
        }
    }

}