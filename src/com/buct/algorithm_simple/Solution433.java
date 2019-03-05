package com.buct.algorithm_simple;

/**
 * 岛屿的个数
 * 给一个01矩阵，求不同的岛屿的个数。

 0代表海，1代表岛，如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 思路：
 对某个位置（i,j）

 当是1 的时候，是岛屿，该位置设为 0 ，并将四周的 1 设置为 0，这样就是递归思想了

 当是0的时候，不是岛屿，寻找下一个位置

 */
public class Solution433 {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if(grid.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == true) {
                    count ++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    void dfs(boolean[][] grid, int i, int j) {
        if(i>=grid.length || i<0 || j<0 || j>=grid[0].length) {
            return ;
        }
        if(grid[i][j] == true) {
            grid[i][j] = false;
            dfs(grid,i-1,j);
            dfs(grid,i+1,j);
            dfs(grid,i,j-1);
            dfs(grid,i,j+1);

        }
    }
}