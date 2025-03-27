package com.lynx.lc.c0;

import com.lynx.util.SinglyLinkedList.ListNode;

/**
 * 61. 旋转链表
 */
public class Lc0061 {
    private static final ListNode[] stack = new ListNode[501];

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 将所有节点放入栈中
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            stack[size++] = cur;
            cur = cur.next;
        }
        // 特例
        k %= size;
        if (k == 0) {
            return head;
        }
        // 弹出栈顶节点(即尾节点)，其next指向头节点，更新头节点
        for (int i = 0; i < k; i++) {
            ListNode tail = stack[--size];
            tail.next = head;
            head = tail;
        }
        // 循环k次后，栈顶节点就是新的尾节点，其next指向空
        stack[size - 1].next = null;
        return head;
    }
}
