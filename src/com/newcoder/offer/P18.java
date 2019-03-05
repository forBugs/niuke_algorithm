package com.newcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;


/**
 * 判断一个二叉树是否是另一款二叉树的子树
 * @author Administrator
 *
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class P18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        
        if(root1 == root2) {
        	return true;
        }
        if(root2 ==null) {
        	return true;
        }
        if(root1 == null && root2 != null) {
        	return false;
        }
        
        // 先从树A中找到与树B根节点 值相等的节点  
        if(root1.val == root2.val) {
        	result = match(root1,root2);
        }
        
    	if(result)
    		return true;
    	// 递归比较A的左子树和右子树
    	return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    	
    }

    /**
     * 判断两个数是否相等
     * @param root1
     * @param root2
     * @return
     */
	public boolean match(TreeNode root1, TreeNode root2) {

        if(root1 == root2) {
        	return true;
        }
        if(root2 ==null) {
        	return true;
        }
        if(root1 == null) {
        	return false;
        }
        
        // 递归地比较左子树和右子树是否一致
        if(root1.val == root2.val) {
        	return match(root1.left, root2.left) && match(root1.right, root2.right);
        }
		return false;
	}
}
		
