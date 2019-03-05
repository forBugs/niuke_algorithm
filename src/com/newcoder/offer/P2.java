package com.newcoder.offer;

import java.util.ArrayList;
import java.util.Stack;

public class P2 {


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null)
            return list;
        ListNode p = listNode;
        Stack<ListNode> stack = new Stack<>();
        while(p != null) {
        	stack.push(p.next);
        	p = p.next;
        }
        while(!stack.isEmpty()) {
        	ListNode temp = stack.pop();
        	list.add(temp.val);
        }
        

        return list;
        
    }
    

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }


    }
}
