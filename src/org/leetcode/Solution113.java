package org.leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution113 {
    List<List<Integer>> lists;
    List<Integer> list;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        lists = new ArrayList<>();
        list = new ArrayList<>();
        pathSumHelper(root,sum,0);
        return lists;
    }

    void pathSumHelper(TreeNode root, int sum, int curSum) {
        if (root == null) {
            return ;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {

            if (root.val + curSum == sum) {
                lists.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return ;
        }

        pathSumHelper(root.left, sum, curSum + root.val);
        pathSumHelper(root.right, sum,curSum + root.val);
        list.remove(list.size() - 1);

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