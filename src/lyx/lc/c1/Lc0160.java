package lyx.lc.c1;

import lyx.util.SinglyLinkedList.ListNode;

/**
 * 160. 相交链表
 */
public class Lc0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // A的长度
        int sizeA = 0;
        ListNode curA = headA;
        while (curA != null) {
            sizeA++;
            curA = curA.next;
        }
        curA = headA;
        // B的长度
        int sizeB = 0;
        ListNode curB = headB;
        while (curB != null) {
            sizeB++;
            curB = curB.next;
        }
        curB = headB;
        // 较长的先遍历多出的长度，然后一起遍历
        while (sizeA > sizeB) {
            sizeA--;
            curA = curA.next;
        }
        while (sizeB > sizeA) {
            sizeB--;
            curB = curB.next;
        }
        while (sizeA > 0) {
            if (curA == curB) {
                return curA;
            }
            sizeA--;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
