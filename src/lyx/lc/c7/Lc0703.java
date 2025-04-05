package lyx.lc.c7;

import java.util.PriorityQueue;

/**
 * 703.数据流中的第K大元素
 */
public class Lc0703 {

    /**
     * 利用小根堆实现.
     */
    public static class KthLargest {

        final PriorityQueue<Integer> queue = new PriorityQueue<>();

        final int kth;

        public KthLargest(int k, int[] nums) {
            this.kth = k;
            for (int num : nums) {
                this.queue.offer(num);
                if (this.queue.size() > k) {
                    this.queue.poll();
                }
            }
        }

        public int add(int val) {
            this.queue.offer(val);
            if (queue.size() > this.kth) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
