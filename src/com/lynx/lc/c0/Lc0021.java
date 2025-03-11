package com.lynx.lc.c0;

import com.lynx.util.SinglyLinkedList.ListNode;

/**
 * 21.合并两个有序链表
 */
public class Lc0021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode min;
        if (list1.val <= list2.val) {
            min = list1;
            min.next = mergeTwoLists(list1.next, list2);
        } else {
            min = list2;
            min.next = mergeTwoLists(list1, list2.next);
        }
        return min;
    }


}
