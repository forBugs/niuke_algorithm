package com.newcoder.offer;

/**
 * 两个有序链表合并
 * @author Administrator
 *
 */
public class P17 {
	
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode next1,next2;
        
        // 定义逻辑节点
        ListNode root = new ListNode(0);
        ListNode curr = root;
        while(curr1 != null && curr2 !=null) {
        	if(curr1.val <= curr2.val) {
//        		next1 = curr1.next;
        		curr.next = curr1;
        		curr = curr.next;
        		curr1 = curr1.next;
        		
        	} else {
        		curr.next = curr2;
        		curr = curr.next;
        		curr2 = curr2.next;
        	}
        	
        }
        if(curr1 != null) {
        	curr.next = curr1;
        }
        if(curr2 != null) {
        	curr.next = curr2;
        }
    	
    	return root.next;
    }
    
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }


    }

	
	
}
		
