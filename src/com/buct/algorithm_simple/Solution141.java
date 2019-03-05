package com.buct.algorithm_simple;

/**
 * x的平方根
 * 实现 int sqrt(int x) 函数，计算并返回 x 的平方根
 * 思路：
 *      使用二分法，将 mid*mid 的值与 x 比较，但为了防止计算评方时发生溢出，二分上限为 46341 而非 x 的值。
 又因为待求数的平方根有可能是介于两个整数之间的，这种情况需要做一下判断处理，否则会陷入死循环中。
 */
public class Solution141 {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        int low = 0;
        int high = 46341;
        int middle = 0;

        while (low <= high) {
            if (middle == (low + high) / 2) {
                break;
            }
            middle = (low + high) / 2;
            if (middle * middle == x) {
                return middle;
            } else if (middle * middle > x) {
                high = middle;
            } else {
                low = middle;
            }
        }

        return middle;
    }
}