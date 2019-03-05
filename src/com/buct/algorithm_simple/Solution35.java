package com.buct.algorithm_simple;


import java.lang.reflect.WildcardType;

/**
 * 反转链表
 */


public class Solution35 {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode next = curr.next;

        while (next != null) {
            ListNode temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }
        head.next = null;

        return curr;
    }


    // Definition for ListNode
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}