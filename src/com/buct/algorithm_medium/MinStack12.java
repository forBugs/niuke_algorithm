package com.buct.algorithm_medium;

import org.junit.Test;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.List;

/**
 * 带最小值操作的栈
 * 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。

 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。

 思路：
 定义两个ArrayList来存储栈，一个ArrayList存储当前栈中的元素，一个ArrayList存储最小栈，并且其第i个元素表示栈中前i个元素的最小值，这样两个栈的长度是始终一样的

 入栈：最小栈需要加入的元素是 当前要入的元素和list中最后一个元素的最小值

 出栈：最小栈也要出栈的，不需要进行比较，直接出栈

 获取最小值：就是去栈顶元素的，直接取出list 中最后一个元素就好了

 */
public class MinStack12 {
    private List<Integer> stack;
    private List<Integer> minStack;
    public MinStack12() {
        // do intialization if necessary
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.add(number);
        if (minStack.size() == 0) {
            minStack.add(number);
        } else {
            minStack.add(Math.min(number,minStack.get(minStack.size() - 1)));
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        Integer result = stack.remove(stack.size() - 1);

        minStack.remove(minStack.size() - 1);
        return result;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.get(minStack.size() - 1);
    }
}