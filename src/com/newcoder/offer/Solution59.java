package com.newcoder.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 把二叉树打印成多行
 */
public class Solution59 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        int start = 0;
        int end = 1;  // 根节点这一层总共一个节点
        if (pRoot == null) {
            return lists;
        }
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            temp.add(node.val);
            start ++;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (start == end) {
                lists.add(temp);
                temp = new ArrayList<>();
                start = 0;
                end = queue.size();
            }

        }
        return lists;
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