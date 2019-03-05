package com.buct.algorithm_simple;

/**
 * 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。

 你应该保留两部分内链表节点原有的相对顺序。
 思路：划分成两个链表并合并
 */
public class Solution96 {
    /**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here

        if(head==null || head.next == null) {
            return head;
        }
        ListNode fakehead1 = new ListNode(0);
        ListNode fakehead2 = new ListNode(0);
        ListNode p1 = fakehead1;
        ListNode p2 = fakehead2;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                p1.next = new ListNode(p.val);
                p1 = p1.next;
            } else {
                p2.next = new ListNode(p.val);
                p2 = p2.next;
            }
            p = p.next;
        }

        // 合并
        p1.next = fakehead2.next;
        return fakehead1.next;
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