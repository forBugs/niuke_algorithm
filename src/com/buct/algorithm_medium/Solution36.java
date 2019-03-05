package com.buct.algorithm_medium;

import java.util.List;

/**
 * 翻转链表  翻转链表中第m个节点到第n个节点的部分
 */
public class Solution36 {
    /**
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = head;
        ListNode prev = dummy;
        for (int i = 1; i < m; i++) {
            prev = start;
            start = start.next;
        }
        ListNode end = start;
        for (int i = m; i < n; i++) {
            end = end.next;
        }
        ListNode plus = end.next;
        ListNode curr = start;
        ListNode next = curr.next;
        for (int i = m; i < n; i++) {
            ListNode temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }
        prev.next = curr;
        start.next = plus;
        return dummy.next;
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}