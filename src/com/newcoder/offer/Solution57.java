package com.newcoder.offer;

/**
 * 序列化和反序列化二叉树
 *
 * 思路：使用前序遍历的思想，对每个字符加逗号进行追加，对空子节点以#加逗号进行追加
 *      反序列化时首先使用逗号对字符串进行分割，之后仍然使用前序遍历的方式进行反序列化，使用一个计数器
 */
public class Solution57 {
    int index = -1;
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {

        index++;
        String[] strs = str.split(",");
        TreeNode node = null;
        if (!strs[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
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