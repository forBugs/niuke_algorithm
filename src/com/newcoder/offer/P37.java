package com.newcoder.offer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class P37 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            } else {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }

        }

        return null;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
