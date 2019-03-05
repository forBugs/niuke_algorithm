package com.newcoder.offer;

import java.util.Arrays;

/**
 * 旋转数组的最小元素
 * 
 * @author Administrator
 *
 */
public class P5 {

	public int minNumberInRotateArray(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int left = 0;
		int right = array.length - 1;
		int mid = 0;
		while (array[left] >= array[right]) {
			if (right - left<=1) {
				mid = right;
				break;
			}
			mid = (left + right) / 2;
			if (array[left] == array[mid] && array[mid] == array[right]) {
				if (array[left + 1] != array[right - 1]) {
					mid = array[left + 1] < array[right - 1] ? left + 1 : right - 1;
				} else {
					left++;
					right--;
				}
			} else {
				if (array[mid] >= array[left]) {
					left = mid;
				} else {
					right = mid;
				}
			}
		}
		return array[mid];
	}
}
