package com.newcoder.offer;

/**
 * 二叉搜索树的后续便遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class P24 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if(sequence.length == 1) {
            return true;
        }
        return judge(sequence,0,sequence.length - 1);
    }

    boolean judge(int[] sequence, int start, int root) {
        if(start >= root) {
            return true;
        }
        // 从最后一个元素往前找到第一个比根元素小的位置  即左子树父节点
        int i = root - 1;
        while (i > start && sequence[i] > sequence[root])
            i--;
        // 便利前边的元素序列
        for (int j = start; j <= i; j++) {
            if(sequence[j] > sequence[root])
                return false;
        }
        return judge(sequence,start,i) && judge(sequence,i+1,root-1);
    }


}