package com.buct.algorithm_simple;
/**
 * 在二叉查找树中插入节点
 * 给定一棵二叉查找树和一个新的树节点，将节点插入到树中。

 你需要保证该树仍然是一棵二叉查找树。
 */






public class Solution85{
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        // 定义一个当前节点  和一个父节点
        TreeNode current = root;
        TreeNode parent ;
        while (true) {
            parent = current;
            if (node.val < current.val) {
                // 转向左子树
                if (current.left == null) {
                    parent.left = node;
                    break;
                } else {
                    current = current.left;
                }

            } else {
                //转向右子树
                if (current.right == null) {
                    parent.right = current;
                    break;
                } else {
                    current = current.right;
                }
            }
        }
        return root;
    }




//Definition of TreeNode:
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

}