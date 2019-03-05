package com.buct.algorithm_simple;

/**
 * 链表求和
 * 你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，
 * 使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
 */
public class Solution167 {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode fakehead = new ListNode(0);
        ListNode p = fakehead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while (p1 != null && p2 != null) {
            int num1 = 0;
            if (p1 != null) {
                num1 = p1.val;
                p1 = p1.next;
            }            
            
            int num2 = 0;
            if (p2 != null) {
                num2 = p2.val;
                p2 = p2.next;
            }

            int temp = (num1 + num2 + carry) % 10;
            p.next = new ListNode(temp);
            p = p.next;
            carry = (num1+num2+carry)/10;
        }
        // 判断最高位
        if(carry == 1) {
            p.next = new ListNode(1);
        }
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