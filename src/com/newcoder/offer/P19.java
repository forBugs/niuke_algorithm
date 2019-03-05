package com.newcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;


/**
 * 顺时针打印矩阵
 * @author Administrator
 *
 */
public class P19 {
	
    public ArrayList<Integer> printMatrix(int [][] matrix) {
    	ArrayList<Integer> res = new ArrayList<>();

    	int rows = matrix.length;
    	int cols = matrix[0].length;
		int x = 0,y=0;
		while (2*x < matrix.length && 2*y < matrix[0].length) {

			// 分四步
			// 最上边的一条线
			for (int i = y; i <= cols - 1 - y; i++) {
				res.add(matrix[x][i]);

			}
			// 最右边一条线
			if (rows - 1 - x > x) {
				for (int i = x+1; i <= rows-1-x; i++) {
					res.add(matrix[i][cols-1-y]);
				}

			}
			// 最下边那条线
			if (rows-1-x > x && cols-1-y > y) {
				for (int i = cols-2-y; i >= y ; i--) {
					res.add(matrix[rows-1-x][i]);
				}
			}
			//最左边一条线
			if(cols-1-y > y && rows-1-x > x+1) {
				for (int i = rows-2-x; i >= x+1 ; i--) {
					res.add(matrix[i][y]);
				}
			}
			x++;
			y++;
		}
		return res;
    }

	
	
}
		
