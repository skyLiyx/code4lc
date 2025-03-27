package com.lynx.lc.c0;

import com.lynx.util.SinglyLinkedList.ListNode;

/**
 * 92. 反转链表 II
 */
public class Lc0092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }
        int size = 0;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        ListNode leftEnd = null;
        ListNode reverseBegin = null;
        while (cur != null) {
            size++;
            next = cur.next;
            if (size == left) {
                // 记录左边尾节点
                leftEnd = pre;
                // 记录反转区起始节点
                reverseBegin = cur;
            }
            if (size > left && size <= right) {
                cur.next = pre;
            }
            if (size == right) {
                // 反转区结束，反转区起始节点变成尾节点，指向右边起始节点
                reverseBegin.next = next;
                // 左边尾节点，指向反转区结束节点
                if (leftEnd != null) {
                    leftEnd.next = cur;
                } else {
                    head = cur; // 头节点就开始反转的情况
                }
            }
            pre = cur;
            cur = next;
        }
        return head;
    }
}
