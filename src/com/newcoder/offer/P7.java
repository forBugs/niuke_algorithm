package com.newcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author Administrator
 *
 */
public class P7 {

	private int NumberOf1_low(int n) {
		int count = 0;
		int flag = 1;
		while(flag != 0) {
			 if((n & flag) != 0) {
				 count ++;
			 }
			 flag = flag << 1;
		}
		return count;
	}

	
	private int NumberOf2_low(int n) {
		
	
		int count = 0;
		while( n!= 0) {
			
			count ++;
			n = n & (n-1);
		}
		
		return count;
	}
	@Test
	public void test() {
		int i = NumberOf1_low(100);
//		System.out.println("i:" + i);
		
		double a = 1.230000000;
		double b = 0.125688;
	
//		System.out.println(a);
		
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		
		l2.add(3);
		l2.add(4);
		l2.add(5);
//		l1.addAll(l2);
//		l1.retainAll(l2);
//		l1.removeAll(l2);
//		l1.addAll(l2);
		
		
		for (Integer integer : l1) {
			System.out.println(integer);
		}
		
		
		
		
		
	}
}
