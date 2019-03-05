package com.buct.algorithm_simple;

/**
 * 翻转二叉树
 * 交换左右子树
 * 思路：交换左右子树，使用递归的方法
 */
public class Solution175 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return ;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;
            invertBinaryTree(root.left);
            invertBinaryTree(root.right);
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