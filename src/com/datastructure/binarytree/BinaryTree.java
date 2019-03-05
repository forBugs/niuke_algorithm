package com.datastructure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {


    /**
     * 二叉树非递归前序遍历
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> preOrder2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                cur = pop.right;
            }
        }
        return list;
    }

    /**
     * 二叉树递归遍历
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
        return list;
    }

    /**
     * 非递归中序遍历
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> inOrder2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                cur = pop.right;
            }
        }

        return list;
    }

    /**
     * 二叉树递归遍历
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            preOrder(root.left);
            list.add(root.val);
            preOrder(root.right);
        }
        return list;
    }

    /**
     * 二叉树后序遍历
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            preOrder(root.left);
            preOrder(root.right);
            list.add(root.val);
        }
        return list;
    }

    /**
     * 后续非递归遍历
     * 要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。
     * 如果P不存在左孩子和右孩子，则可以直接访问它；或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，
     * 则同样可以直接访问该结点。若非上述两种情况，则将P的右孩子和左孩子依次入栈，
     * 这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> postOrder2(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 标志当前节点的左右子节点是否已经被访问过
        TreeNode cur = null;
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                pre = pop;
            } else {
                if (cur.right != null)
                    stack.push(cur.right);
                if(cur.left != null)
                    stack.push(cur.left);
            }
        }
        return list;
    }

    /**
     * 层次遍历 用到遍历
     * @param root
     * @return
     */
    public ArrayList<Integer> levelOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 将当前节点入队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 出队列 并打印
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }

}


