package com.lynx.lc.c3;

/**
 * 346. 数据流中的移动平均值
 */
public class Lc0346 {

    public static class MovingAverage {
        private final int[] queue = new int[10001];
        private int s, l, r, sum;

        public MovingAverage(int size) {
            s = size;
            l = r = sum = 0;
        }

        public double next(int val) {
            queue[r++] = val;
            sum += val;
            if (r - l > s) {
                sum -= queue[l++];
            }
            return (double)sum / (r - l);
        }
    }
}
