package com.newcoder.offer;

import java.util.ArrayList;

/**
 * 数组中最小的k个数
 */
public class P30 {


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(k > input.length) {
            return res;
        }
        for (int i = 0; i < k; i++) {
            for (int j = input.length - 1 - i; j >= i + 1; j--) {
                if (input[j] < input[j - 1]) {
                    int temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }

            }
            res.add(input[i]);

        }

        return res;
    }
}
