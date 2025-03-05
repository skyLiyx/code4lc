package com.lynx.util;

public class DoublyLinkedList {

    /**
     * 双向链表节点。
     */
    public static class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode prev, ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
