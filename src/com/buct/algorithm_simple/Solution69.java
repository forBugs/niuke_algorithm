package com.buct.algorithm_simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 *
 * 思路：
 *  队列很容易，先加入，然后取出来的同时加入左右孩子节点

 在剑指offer中有个题目和这个很类似，其只是层次遍历二叉树，没有要求把每层的节点单独放在一起的。

 上面说的规律：每一次打印一个节点的时候，如果该结点有子结点，则把该结点的子结点放到一个队列的尾部。接下来到队列的头部取出最早进入队列的结点。

 重复前面的打印操作，直到队列中所有的结点都被打印出来为止。

 上面是层次打印所有节点，而不是对每一层的节点放在一个list中输出，所以队列保存当前层的元素。

 */
public class Solution69 {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> tree = new ArrayList<List<Integer>>();
        if (root == null) {
            return tree;
        }
        //  根节点入队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    // 左子树不为空 入队列
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    // 右子树不为空 入队列
                    queue.offer(node.right);
                }

            }
            tree.add(list);
        }

        return tree;
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