package lyx.lc.c4;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU 缓存
 */
public class Lc0460 {

    public static class LFUCache {
        private final Map<Integer, DLinkedList> frequency;
        private final Map<Integer, Node> cache;
        private final int capacity;
        private int minFreq;

        public LFUCache(int capacity) {
            this.frequency = new HashMap<>();
            this.cache = new HashMap<>();
            this.capacity = capacity;
            minFreq = 0;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                updateFreq(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.val = value;
                updateFreq(node);
            } else {
                Node newNode = new Node(key, value, 1);
                cache.put(key, newNode);
                if (cache.size() > capacity) {
                    DLinkedList dLinkedList = frequency.get(minFreq);
                    Node removed = dLinkedList.removeTail();
                    cache.remove(removed.key);
                }
                setFrequency(1, newNode);
                minFreq = 1;
            }
        }

        private void setFrequency(int freq, Node node) {
            if (frequency.containsKey(freq)) {
                frequency.get(freq).addToHead(node);
            } else {
                frequency.put(freq, new DLinkedList(node));
            }
        }

        private void updateFreq(Node node) {
            DLinkedList dLinkedList = frequency.get(node.freq);
            dLinkedList.remove(node);
            if (minFreq == node.freq && dLinkedList.size == 0) {
                minFreq++;
            }
            setFrequency(++node.freq, node);
        }

        private static class Node {
            public int key;
            public int val;
            public int freq;
            public Node next;
            public Node prev;

            public Node() {
            }

            public Node(int key, int val, int freq) {
                this.key = key;
                this.val = val;
                this.freq = freq;
            }
        }

        private static class DLinkedList {
            Node head;
            Node tail;
            int size;

            public DLinkedList(Node node) {
                this.head = new Node();
                head.next = node;
                this.tail = new Node();
                tail.prev = node;
                node.prev = this.head;
                node.next = this.tail;
                size = 1;
            }

            public void remove(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
            }

            public Node removeTail() {
                Node target = this.tail.prev;
                remove(target);
                target.prev = null; // 自动回收
                target.next = null;
                return target;
            }

            public void addToHead(Node node) {
                node.next = this.head.next;
                node.prev = this.head;
                this.head.next.prev = node;
                this.head.next = node;
                size++;
            }
        }
    }
}
