package com.lynx.lc.c0;

import com.lynx.util.SinglyLinkedList.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 */
public class Lc0083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                // 把前一个节点next从当前节点指向下一个节点
                pre.next = cur.next;
                cur.next = null; // 移除当前节点，交给GC自动回收
            } else {
                // 否则移动pre指向到当前节点
                pre = cur;
            }
            cur = pre.next;
        }
        return head;
    }
}
