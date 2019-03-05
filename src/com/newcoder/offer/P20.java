package com.newcoder.offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class P20 {
    Integer[] elements = new Integer[10];
    int size;
    Stack<Integer> minStack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int node) {
        // 考虑扩容问题
        ensureCapacity(size+1);
        elements[size++] = node;

        if(node <= min) {
            minStack.push(node);
            min = minStack.peek();
        } else {
            minStack.push(min);
        }
    }

    // 数组扩容
    private void ensureCapacity(int minCapacity) {
        int length = elements.length;
        if(minCapacity > length) {
            int newLength = (length*3)/2 + 1;
            if(newLength < minCapacity) {
                newLength = minCapacity;
            }
            elements = Arrays.copyOf(elements,newLength);

        }
    }

    public void pop() {
        Integer top = top();
        if(top != null) {
            elements[size-1] = (Integer)null;
            size --;
            minStack.pop();
            min = minStack.peek();
        }

    }

    // 获取栈顶元素的值
    public Integer top() {
        if(!isEmpty() && size-1 >= 0) {
            return elements[size - 1];
        }
        return (Integer)null;
    }

    boolean isEmpty() {
        return size == 0;
    }
    public int min() {

        return min;
    }
}
