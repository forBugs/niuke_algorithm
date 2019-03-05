package com.buct.algorithm_medium;

/**
 * . 中序遍历和前序遍历树构造二叉树
 根据中序遍历和前序遍历树构造二叉树
 */
public class Solution73 {
    /**
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param preorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if(preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

    public int findroot(int[] inorder,int root) {
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (istart > iend) {
            return null;
        }
        // 找到根节点
        int r = preorder[pstart];
        TreeNode root = new TreeNode(r);
        int l = findroot(inorder, r);
        // 递归
        root.left = buildTree(preorder,pstart+1,pstart+1+(l-1-istart+1)-1,inorder,istart,l-1);
        root.right = buildTree(preorder,pstart+1+(l-1-istart+1),pend,inorder,l+1,iend);
        return root;

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