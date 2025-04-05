package lyx.lc.c0;

import lyx.util.SinglyLinkedList.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 */
public class Lc0082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode virtualHead = new ListNode(0);
        ListNode virtualCur = virtualHead;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            if (next == null) {
                virtualCur.next = cur;
                cur = null;
            } else if (cur.val != next.val) {
                virtualCur.next = cur;
                cur = next;
                next = cur.next;
                virtualCur = virtualCur.next;
                // 当前存放结果的节点与原链表脱钩
                virtualCur.next = null;
            } else {
                // 当前节点值和下一节点值一样，调整当前节点到下一个值不同的节点
                while (next.next != null && next.next.val == cur.val) {
                    next = next.next;
                }
                cur = next.next;
                next = cur == null ? null : cur.next;
            }
        }
        return virtualHead.next;
    }
}
