package com.buct.algorithm_medium;


import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉查找树
 * 思路：验证中序遍历是否是有序的
 *
 */
public class Solution95 {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        List<Integer> inorderList = new ArrayList<>();
        inorderList(root, inorderList);
        for (int i = 0; i < inorderList.size()-1; i++) {
            if(inorderList.get(i) >= inorderList.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    void inorderList(TreeNode root,List<Integer> list) {
        if(root !=null) {
            inorderList(root.left,list);
            list.add(root.val);
            inorderList(root.right,list);
        }
    }



    /**
     * Definition of TreeNode:
     **/
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}