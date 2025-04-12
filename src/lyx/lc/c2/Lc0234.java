package lyx.lc.c2;

import lyx.util.SinglyLinkedList.ListNode;

/**
 * 234. 回文链表
 */
public class Lc0234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow);
        while (secondHalf != null) {
            if (head.val != secondHalf.val) {
                return false;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
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
