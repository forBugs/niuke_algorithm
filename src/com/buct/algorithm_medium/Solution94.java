package com.buct.algorithm_medium;

/**
 * 94. 二叉树中的最大路径和
 给出一棵二叉树，寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束（路径和为两个节点之间所在路径上的节点权值之和）
 */
public class Solution94 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        maxSum(root,max);
        return max;
    }

    private int maxSum(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int left = maxSum(root.left,max);
        int right = maxSum(root.right, max);
        max = Math.max(max, Math.max(0, left) + Math.max(0, right) + root.val);
        return Math.max(0, Math.max(left,right))+root.val;
    }

    /**
     * Definition of TreeNode:
     **/
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

}