package lyx.lc.c0;

import lyx.util.SinglyLinkedList.ListNode;

/**
 * 2.两数相加
 */
public class Lc0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l2 != null) {
            l1.val = l1.val + l2.val;
            if (l1.val > 9) {
                plusNextVal(l1);
            }
            if (l1.next != null) {
                addTwoNumbers(l1.next, l2.next);
            } else if (l2.next != null) {
                l1.next = l2.next;
            }
        }
        return l1;
    }

    private void plusNextVal(ListNode l) {
        if (l.next == null) {
            l.next = new ListNode(1);
        } else if (l.next.val == 9) {
            l.next.val = 0;
            plusNextVal(l.next);
        } else {
            l.next.val++;
        }
    }
}
