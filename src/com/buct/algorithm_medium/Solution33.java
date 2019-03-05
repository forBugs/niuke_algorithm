package com.buct.algorithm_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * N皇后问题   n皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。

 给定一个整数n，返回所有不同的n皇后问题的解决方案。

 每个解决方案包含一个明确的n皇后放置布局，其中“Q”和“.”分别表示一个女王和一个空位置。

 思路：

 */
public class Solution33 {
    private HashSet<Integer> locations = new HashSet<>();
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        if (n <= 0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        char[][] matrix = new char[n][n];
        for (char[] line : matrix) {
            Arrays.fill(line,'.');
        }
        helper(matrix, ans, 0);
        return ans;

    }

    private void helper(char[][] matrix, List<List<String>> ans, int index) {
        int n = matrix.length;
        if (index == n) {
            ans.add(copyMatrix(matrix));
            return ;
        }
        for (int i = 0; i < n; i++) {
            if(isValid(n,index,i)) {
                int location = index*n + i;
                locations.add(location);
                matrix[index][i] = 'Q';
                helper(matrix, ans, index + 1);
                matrix[index][i] = '.';
                locations.remove(location);
            }
        }
    }

    private boolean isValid(int n, int row, int col) {

        for (Integer location : locations) {

            int r = location / n,c = location % n;
            if(c == col || Math.abs(row - r) == Math.abs(col - c)) {
                return false;
            }
        }
        return true;
    }

    private List<String> copyMatrix(char[][] matrix) {
        ArrayList<String> copy = new ArrayList<>();
        for (char[] chars : matrix) {
            copy.add(new String(chars));
        }
        return copy;
    }
}