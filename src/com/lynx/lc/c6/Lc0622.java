package com.lynx.lc.c6;

/**
 * 622.设计循环队列
 */
public class Lc0622 {

    /**
     * 实现原理：
     * <p>准备一个数组，长度在构造时指定，利用两个指针分别表示队列
     * 的边界（左闭右开），然后定义队列的当前大小和上限。另外根据循
     * 环队列的定义，左右边界越界时，都重新指到数组0位置。
     */
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
            // 入队从队尾进入，即右边界位置设置值，并将右边界右移
            queue[r++] = value;
            // 越界时指到0位置
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
            // 出队从队首出去，即左边界。直接将左边界右移
            // 同样的，越界时指到0位置
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
            // 队首即左边界的值（左闭右开）
            return queue[l];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            // 队尾是右边界前一个值（左闭右开）
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
