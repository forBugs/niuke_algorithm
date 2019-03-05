package org.leetcode;

class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {

        return hasPathSumHelper(root,sum,0);
    }

    boolean hasPathSumHelper(TreeNode root, int sum, int curSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if ((curSum + root.val) == sum) {
                return true;
            }
        }

        return hasPathSumHelper(root.left, sum, curSum + root.val) || hasPathSumHelper(root.right, sum, curSum + root.val);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}


