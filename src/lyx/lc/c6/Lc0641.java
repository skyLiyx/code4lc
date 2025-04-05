package lyx.lc.c6;

/**
 * 641.设计循环双端队列
 */
public class Lc0641 {

    /**
     * 实现原理和设计循环队列差不多。另外由于循环双端队列的定义，
     * 当左右边界越界时，都重新指到数组0位置或最后一个位置。
     *
     * @see Lc0622.MyCircularQueue
     */
    public static class MyCircularDeque {

        int[] deque;
        int l;
        int r;
        int size;
        int limit;

        public MyCircularDeque(int k) {
            deque = new int[k];
            // 左开右闭
            l = r = size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            // 从队首入队，设置左边界的值，左边界左移
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
            // 从队尾入队，右移右边界，再设置右边界的值
            r = r == limit - 1 ? 0 : r + 1;
            deque[r] = value;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            // 从队首出队，直接右移左边界
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
            // 从队尾出队，直接左移右边界
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
            // 获取队首的值，即左边界右边的值
            int head = l == limit - 1 ? 0 : l + 1;
            return deque[head];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            // 获取队尾的值，即右边界的值
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
