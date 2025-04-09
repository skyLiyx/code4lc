package lyx.lc.c32;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3296. 移山所需的最少秒数
 */
public class Lc3296 {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long min = Integer.MAX_VALUE;
        for (int workerTime : workerTimes) {
            min = Math.min(min, workerTime);
        }
        long l = 1, r = min * mountainHeight * (mountainHeight + 1) / 2, m;
        long ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(mountainHeight, m, workerTimes)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private boolean check(int mountainHeight, long time, int[] workerTimes) {
        for (int workerTime : workerTimes) {
            mountainHeight -= (int) ((Math.sqrt((double) time / workerTime * 8 + 1) - 1) / 2);
            if (mountainHeight <= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 小根堆
     */
    public long minNumberOfSeconds1(int mountainHeight, int[] workerTimes) {
        PriorityQueue<long[]> heap = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        for (int workerTime : workerTimes) {
            heap.add(new long[]{workerTime, workerTime, 1});
        }
        long ans = 0;
        while (mountainHeight > 0) {
            long[] minCost = heap.poll();
            long next = minCost[0], base = minCost[1], times = minCost[2] + 1;
            ans = next;
            mountainHeight--;
            heap.add(new long[]{ next + base * times, base, times });
        }
        return ans;
    }
}
