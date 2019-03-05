package com.newcoder.offer;

import java.util.LinkedList;
/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 */
public class Solution47 {
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }
}