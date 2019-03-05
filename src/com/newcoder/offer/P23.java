package com.newcoder.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class P23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        // 辅助队列   存储上一层的父节点
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return res;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            //
            TreeNode node = queue.remove();
            res.add(node.val);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }

        }
        return res;
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
