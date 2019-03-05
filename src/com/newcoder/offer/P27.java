package com.newcoder.offer;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class P27 {

    /**
     *方法一：非递归版
     解题思路：
     1.核心是中序遍历的非递归算法。
     2.修改当前遍历节点与前一遍历节点的指针指向。

     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null) {
            return null;
        }
        // 使用中序非递归遍历
        TreeNode cur = pRootOfTree;
        TreeNode pre = null;
        TreeNode newRoot = null;
        Stack<TreeNode> stack = new Stack<>();
        boolean isFirst = true;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty()) {
                cur = stack.pop();
                // 判断是否是中序遍历的第一个节点
                if(isFirst) {
                    newRoot = cur;
                    pre = cur;
                    isFirst = false;
                } else{
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }
            }
            cur = cur.right;
        }

        return newRoot;

    }

    // 转化之后的双向链表的首节点
    TreeNode readHead = null;
    // 中序遍历序列中当前节点的前驱结点
    TreeNode prev = null;
    /**
     * 递归版
     * 采用中序遍历修改中序遍历，在其中加入一个前驱结点,
     * 遍历左子树
     当前结点指向左指针指向前驱结点
     前驱结点右指针指向当前结点
     前驱 = 当前
     遍历右子树
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert2(TreeNode pRootOfTree) {

        //递归调用叶子节点的左右节点返回null
        if(pRootOfTree == null) {
            return null;
        }
        //第一次运行时，它会使最左边叶子节点为链表第一个节点
        Convert2(pRootOfTree.left);

        if(readHead == null) {
            readHead = pRootOfTree;
            prev = pRootOfTree;
        } else {
            pRootOfTree.left = prev;
            prev.right = pRootOfTree;
            prev = pRootOfTree;
        }
        //把右叶子节点也插入到双向链表

        Convert2(pRootOfTree.right);
        return readHead;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
