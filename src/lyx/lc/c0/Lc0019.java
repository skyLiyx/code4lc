package lyx.lc.c0;

import lyx.util.SinglyLinkedList.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class Lc0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur1 = head;
        for (int i = 0; i < n; i++) {
            cur1 = cur1.next;
        }
        if (cur1 == null) {
            return head.next;
        }
        ListNode cur2 = head;
        while (cur1.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur2.next = cur2.next.next;
        return head;
    }
}
