package com.lynx.util;

public class SinglyLinkedList {

    /**
     * 单向链表节点。
     */
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
