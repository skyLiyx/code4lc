package lyx.lc.c10;

import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 */
public class Lc1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones) {
            heap.add(s);
        }
        while (heap.size() > 1) {
            int s1 = heap.poll();
            int s2 = heap.poll();
            if (s1 != s2) {
                heap.add(Math.abs(s1 - s2));
            }
        }
        return heap.isEmpty() ? 0 : heap.peek();
    }
}
