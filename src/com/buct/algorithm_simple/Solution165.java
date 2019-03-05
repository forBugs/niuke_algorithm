package com.buct.algorithm_simple;

/**
 * 165. 合并两个排序链表
 *
 */
public class Solution165 {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // write your code here
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        while (p1 != null && p2 != null) {
            int val1 = p1.val;
            int val2 = p2.val;
            if (val1 < val2) {
                p.next = new ListNode(val1);
                p1 = p1.next;
            } else {
                p.next = new ListNode(val2);
                p2 = p2.next;
            }
            p = p.next;

        }

        if(p1 != null){
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return fakeHead.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}