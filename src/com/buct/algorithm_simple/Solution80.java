package com.buct.algorithm_simple;

/**
 * 给定一个未排序的整数数组，找到其中位数。

 中位数是排序后数组的中间值，如果数组的个数是偶数个，则返回排序后数组的第N/2个数。
 */
public class Solution80 {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        // write your code here
        // 先排序
        int[] sort = insertSort(nums);
        if (sort.length % 2 == 0) {
            return sort[sort.length/2-1];
        } else {
            return sort[sort.length/2];
        }

    }

    public int[] insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i-1;  j>=0 ; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }

            }
            arr[j+1] = temp;
        }
        return arr;
    }
}