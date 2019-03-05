package com.newcoder.offer;

import java.util.Arrays;

/**
 * 斐波那契数列
 * 
 * @author Administrator
 *
 */
public class P6 {

    public int Fibonacci(int n) {
    	if(n<=1) {
    		return 1;
    	}
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
    
    public int Fibonacci2(int n) {
    	if(n<=1) {
    		return n;
    	}
    	int[] nums = new int[n+1];
    	nums[0] = 0;
    	nums[1] = 1;
    	for (int i = 2; i < nums.length; i++) {
			nums[i] = nums[i-1] + nums[i-2];
    		
		}
    	return nums[n];
    }
}
