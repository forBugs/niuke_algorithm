package com.buct.algorithm_simple;

/**
 * 链表倒数第n个节点   找到单链表倒数第n个节点，保证链表中节点的最少数量为n。
 *
 * 思路：设置两个指针fast,slow,fast先向前走n步，之后fast和slow一起走，fast是最后一个节点的时候，slow所致的就是答案
 */
public class Solution166 {
    /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list. 
     */
    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;

        }
        return slow;

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