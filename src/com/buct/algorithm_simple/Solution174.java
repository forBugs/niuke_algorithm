package com.buct.algorithm_simple;

/**
 * 删除链表中倒数第n个节点
 * 思路分析：
 采用双指针的方式来解此题，会很容易。
 设置两个指针，其一先走n步，然后二者再一起走，知道先走的指针到达链表的末尾为止。
 */
public class Solution174 {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        ListNode p1 = fakehead;
        for (int i = 0; i < n+1; i++) {
            p1 = p1.next;
        }
        ListNode p2 = fakehead;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 删除p2.next
        p2.next = p2.next.next;
        return fakehead.next;


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