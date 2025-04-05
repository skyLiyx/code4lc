package lyx.lc.c7;

import lyx.util.DoublyLinkedList.ListNode;

/**
 * 707.设计链表
 */
public class Lc0707 {

    public static class MyLinkedList {
        // 双向链表
        ListNode head;
        ListNode tail;
        int size;

        public MyLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode target = find(index);
            return target.val;
        }

        public void addAtHead(int val) {
            ListNode newHead = new ListNode(val, null, head);
            if (head != null) {
                head.prev = newHead;
            }
            head = newHead;
            if (tail == null) {
                tail = head;
            }
            size++;
        }

        public void addAtTail(int val) {
            ListNode newTail = new ListNode(val, tail, null);
            if (tail != null) {
                tail.next = newTail;
            }
            tail = newTail;
            if (head == null) {
                head = tail;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            ListNode target = find(index);
            ListNode newNode = new ListNode(val, target.prev, target);
            target.prev.next = newNode;
            target.prev = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                ListNode target = find(index);
                if (target == head) {
                    head = head.next;
                    head.prev = null; // free memory
                    target.next = null;
                } else if (target == tail) {
                    tail = tail.prev;
                    tail.next = null; // free memory
                    target.prev = null;
                } else {
                    target.prev.next = target.next;
                    target.next.prev = target.prev;
                    target.prev = null; // free memory
                    target.next = null;
                }
            }
            size--;
        }

        private ListNode find(int index) {
            ListNode cur;
            if (index <= (size >> 1)) {
                cur = head;
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
            } else {
                cur = tail;
                for (int i = 0; i < size - 1 - index; i++) {
                    cur = cur.prev;
                }
            }
            return cur;
        }
    }
}