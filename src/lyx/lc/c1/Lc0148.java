package lyx.lc.c1;

import lyx.util.SinglyLinkedList.ListNode;

/**
 * 148. 排序链表
 */
public class Lc0148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = slow.next;
        slow.next = null;
        firstHalf = sortList(firstHalf);
        secondHalf = sortList(secondHalf);
        return merge(firstHalf, secondHalf);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode cur = head;
        ListNode cur1 = head == l1 ? l1.next : l1;
        ListNode cur2 = head == l2 ? l2.next : l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return head;
    }
}
