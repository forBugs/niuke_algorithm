package com.newcoder.offer;

/**
 * 链表反转
 * @author Administrator
 *
 */
public class P16 {
	
	public class Solution {
	    public ListNode ReverseList(ListNode head) {
	         
	    	// 定义逻辑头结点
	    	ListNode root = new ListNode(0);
	    	
	    	// 遍历  头插法
	    	while (head != null) {
	    		// 记录下一个节点
				ListNode next = head.next;
				head.next = root.next;
				root.next = head;
				
				// 
				head = next;
			}
	    	return root.next;
	    }
	}
	
	
	//不适用逻辑头结点
    public ListNode ReverseList2(ListNode head) {
        //
    	ListNode reverseHead = null;
    	ListNode curr = head;
    	ListNode prev = null;
    	ListNode next;
    	
    	while(curr != null) {
    		reverseHead = curr;
    		// 记录下一个节点
    		next = curr.next;
    		
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}

    	return reverseHead;
    }
    
}



class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }


}
		

