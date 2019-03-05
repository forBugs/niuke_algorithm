package com.buct.algorithm_medium;

/**
 * . 中序遍历和后序遍历树构造二叉树
 根据中序遍历和后序遍历树构造二叉树

 1.后序遍历最后一个结点就是根节点，根据这个根结点把中序遍历划分开来，同时也把后续遍历划分开来

 2.递归就好了

 */
public class Solution72 {
    /**
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder.length != postorder.length) {
            return null;
        }
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public int findroot(int[] inorder,int root) {
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root)
                return i;
        }
        return -1;
    }

    private TreeNode buildTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if (istart > iend) {
            return null;
        }
        int r = postorder[pend];
        // 创建根节点
        TreeNode root = new TreeNode(r);
        // 找到根节点
        int l = findroot(inorder,r);
        // 递归
        // 左子树 中序遍历 起始结束位置以此是：istart l-1
        //后序遍历 起始位置是：pstart 结束位置:pstart(已经占据了一个位置所以要-1) + (左子树的长度) - 1
        root.left = buildTree(inorder,istart,l-1,postorder,pstart,pstart+(l-1 - istart + 1) -1);
        // 右子树 中序遍历 起始结束位置：l+1 iend
        // 后序遍历 起始位置：pstart + (左子树的长度) ,结束位置 pend -1
        root.right = buildTree(inorder,l+1,iend,postorder,pstart + (l-1-istart+1),pend -1);
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