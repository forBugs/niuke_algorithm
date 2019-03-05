package com.newcoder.offer;

public class Solution40 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);

        if (Math.abs(leftDepth - rightDepth) <= 1) {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }

        return false;
    }

    public int TreeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);

        return Math.max(leftDepth,rightDepth) + 1;
    }

}