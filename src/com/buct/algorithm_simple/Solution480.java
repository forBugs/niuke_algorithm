package com.buct.algorithm_simple;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给一棵二叉树，找出从根节点到叶子节点的所有路径。
 */
public class Solution480 {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> list = new ArrayList();

        getPath(list,"",root);
        return list;
    }

    private void getPath(List<String> list, String temp, TreeNode root) {
        if(root == null) {
            return ;
        }
        if(root.left == null && root.right==null) {
            String result =  temp +root.val;
            list.add(result);
            return ;
        }
        String next = temp +root.val+"->";
        if(root.left != null) {
            getPath(list,next,root.left);

        }
        if(root.right != null) {
            getPath(list,next,root.right);
        }
    }


    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("haha");
        System.out.println(sb.delete(0,sb.length()).toString());
    }
}