package com.newcoder.offer;

public class Solution39 {
    public int TreeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);

        return Math.max(leftDepth,rightDepth) + 1;
    }



    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}



