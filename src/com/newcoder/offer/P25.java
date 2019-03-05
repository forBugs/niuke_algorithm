package com.newcoder.offer;

import java.util.ArrayList;

/**
 *
 * 二叉树中和为某一值的路径
 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class P25 {

    ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if(root == null ) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));

        }
        // 递归进行左右子树
        FindPath(root.left,target);
        FindPath(root.right,target);
        // 清除最后一个元素  深度遍历完一个路径后要回退
        list.remove(list.size() - 1);

        return listAll;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
