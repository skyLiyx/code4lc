package com.lynx.lc.c6;

/**
 * 622.设计循环队列
 */
public class Lc0622 {

    public static class MyCircularQueue {

        int[] queue;
        int l;
        int r;
        int size;
        int limit;

        public MyCircularQueue(int k) {
            queue = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            queue[r++] = value;
            if (r == limit) {
                r = 0;
            }
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            if (++l == limit) {
                l = 0;
            }
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[l];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            int last = r == 0 ? limit - 1 : r - 1;
            return queue[last];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

}
