package com.buct.algorithm_simple;
/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 二叉树的深度为根节点到最远叶子节点的距离。
 思路:使用递归的方式求解

 */
public class Solution97 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null)
            return 0;
        int res = 0;
        res = depth(res,root);
        return res;
    }

    /**
     * 使用递归的方式实现
     * @param res
     * @param root
     */
    private int depth(int res, TreeNode root) {
        if(root == null)
            return res;
        if (root.left == null && root.right == null) {
            return res+1;
        }
        //找到左子树和右子树的高度的最大值
        int leftHeight = depth(res,root.left)+1;
        int rightHeight = depth(res, root.right)+1;
        return leftHeight > rightHeight ? leftHeight : rightHeight;

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