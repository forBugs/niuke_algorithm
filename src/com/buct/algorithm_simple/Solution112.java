package com.buct.algorithm_simple;

/**
 * 删除排序链表中的重复元素
 *
 */
public class Solution112 {
    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null || head.next == null)  {
            return head;
        }
        ListNode p = head;

        while (p.next != null) {
            if (p.val == p.next.val) {
                // 删除后一个
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
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