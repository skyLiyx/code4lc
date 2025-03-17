package com.lynx.lc.c8;

/**
 * 875. 爱吃香蕉的珂珂
 *
 * @apiNote 二分查找
 */
public class Lc0875 {
    public int minEatingSpeed(int[] piles, int h) {
        int ans = 0;
        int l = 1, r = 0, m;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(piles, h, m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private boolean check(int[] piles, int h, int speed) {
        long cost = 0;
        for (int pile : piles) {
            cost += (pile + speed - 1) / speed;
        }
        return cost <= h;
    }
}
