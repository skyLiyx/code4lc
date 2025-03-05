package com.lynx.lc.c6;

/**
 * 641.设计循环双端队列
 */
public class Lc0641 {

    public static class MyCircularDeque {

        int[] deque;
        int l;
        int r;
        int size;
        int limit;

        public MyCircularDeque(int k) {
            deque = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            deque[l--] = value;
            if (l == -1) {
                l = limit - 1;
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            r = r == limit - 1 ? 0 : r + 1;
            deque[r] = value;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            l++;
            if (l == limit) {
                l = 0;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            r--;
            if (r == -1) {
                r = limit - 1;
            }
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            int head = l == limit - 1 ? 0 : l + 1;
            return deque[head];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return deque[r];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
