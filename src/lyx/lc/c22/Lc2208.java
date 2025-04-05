package lyx.lc.c22;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2208.将数组和减半的最少操作次数
 *
 * @apiNote 堆
 */
public class Lc2208 {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for (int num : nums) {
            sum += num;
            pq.add((double)num);
        }
        double target = sum / 2;
        int ans = 0;
        while (target > 0) {
            double cur = pq.poll() / 2;
            target -= cur;
            pq.add(cur);
            ans++;
        }
        return ans;
    }
}
