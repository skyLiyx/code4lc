package lyx.lc.c1;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 */
public class Lc0146 {

    public static class LRUCache {

        private final Map<Integer, ListNode> map;

        private final ListNode head;
        private final ListNode tail;

        private final int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.head = new ListNode();
            this.tail = new ListNode();
            this.head.next = this.tail;
            this.tail.prev = this.head;
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                ListNode target = map.get(key);
                moveToTail(target);
                return target.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                ListNode target = map.get(key);
                moveToTail(target);
                target.val = value;
            } else {
                ListNode newNode = new ListNode(key, value);
                addLast(newNode);
                map.put(key, newNode);
                if (map.size() > capacity) {
                    ListNode lruNode = this.head.next;
                    remove(lruNode);
                    map.remove(lruNode.key);
                }
            }
        }

        private void remove(ListNode target) {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }

        private void addLast(ListNode target) {
            this.tail.prev.next = target;
            target.prev = this.tail.prev;
            this.tail.prev = target;
            target.next = this.tail;
        }

        private void moveToTail(ListNode target) {
            if (target.next != this.tail) {
                // 先移除
                remove(target);
                // 再插入尾部
                addLast(target);
            }
        }

        /**
         * 双向链表节点。
         */
        public static class ListNode {
            public int key;
            public int val;
            public ListNode prev;
            public ListNode next;

            public ListNode() {
            }

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
