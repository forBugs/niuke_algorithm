package com.buct.algorithm_simple;


/**
 * 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。

 二叉树的最小深度为根节点到最近叶子节点的距离。
 思路：使用递归
 */
public class Solution155 {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if(root==null) return 0;
        if(root.left==null) return minDepth(root.right)+1;
        if(root.right==null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left)+1,minDepth(root.right)+1);
    }


    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}