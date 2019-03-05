package com.buct.algorithm_simple;

import java.util.List;

/**
 * 两两交换链表中的节点
 * 给一个链表，两两交换其中的节点，然后返回交换后的链表。
 * 思路：
 *   //主要是要有一个节点指向要交换的两个节点中第一个的前一个节点，避免链表断开
 */
public class Solution451 {
    /**
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode stHead = res;
        while (stHead.next != null && stHead.next.next != null) {
            ListNode first = stHead.next;
            ListNode second = stHead.next.next;

            first.next = second.next;
            second.next = first;
            stHead.next = second;
            stHead = stHead.next.next;
        }
        return res.next;
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