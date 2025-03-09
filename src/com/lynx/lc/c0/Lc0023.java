package com.lynx.lc.c0;

import com.lynx.util.SinglyLinkedList.ListNode;

import java.util.PriorityQueue;

/**
 * 23.合并K个升序链表
 *
 * @apiNote 堆
 */
public class Lc0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        ListNode head = pq.poll();
        ListNode pre = head;
        if (pre.next != null) {
            pq.offer(pre.next);
        }
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            if (top.next != null) {
                pq.offer(top.next);
            }
            pre.next = top;
            pre = top;
        }
        return head;
    }
}
