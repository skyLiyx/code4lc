package lyx.lc.c2;

import lyx.util.SinglyLinkedList.ListNode;

/**
 * 206. 反转链表
 */
public class Lc0206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
