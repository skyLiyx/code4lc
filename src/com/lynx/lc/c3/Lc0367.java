package com.lynx.lc.c3;

/**
 * 367. 有效的完全平方数
 */
public class Lc0367 {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num, m;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            long multiply = m * m;
            if (multiply == num) {
                return true;
            } else if (multiply < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
