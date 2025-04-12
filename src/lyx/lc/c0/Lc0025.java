package lyx.lc.c0;

import lyx.util.SinglyLinkedList.ListNode;

/**
 * 25.K个一组翻转链表
 */
public class Lc0025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode kthNode = getKthNode(head, k);
        if (kthNode == null) {
            return head;
        }
        ListNode nextGroup = reverseKGroup(kthNode.next, k);
        reverse(head, kthNode);
        head.next = nextGroup;
        return kthNode;
    }

    private ListNode getKthNode(ListNode head, int k) {
        int cnt = 1;
        ListNode cur = head;
        while (cur != null && cnt != k) {
            cur = cur.next;
            cnt++;
        }
        return cur;
    }

    private void reverse(ListNode head, ListNode tail) {
        if (head == tail) {
            return;
        }
        ListNode next = head.next;
        reverse(head.next, tail);
        next.next = head;
    }
}
