package com.lynx.util;

import java.util.StringJoiner;

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

        // for debug
        public static ListNode build(int[] vals) {
            ListNode head = new ListNode(vals[0]);
            ListNode cur = head;
            for (int i = 1; i < vals.length; i++) {
                cur.next = new ListNode(vals[i]);
                cur = cur.next;
            }
            return head;
        }

        // for debug
        @Override
        public String toString() {
            StringJoiner s = new StringJoiner(", ", "[", "]");
            ListNode cur = this;
            while (cur != null) {
                s.add("" + cur.val);
                cur = cur.next;
            }
            return s.toString();
        }
    }
}
