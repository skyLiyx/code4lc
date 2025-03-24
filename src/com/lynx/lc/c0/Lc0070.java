package com.lynx.lc.c0;

/**
 * 70.爬楼梯
 */
public class Lc0070 {
    public int climbStairs(int n) {
        int pre1 = 2, pre2 = 1;
        for (int i = 2, next; i <= n; i++) {
            next = pre2 + pre1;
            pre2 = pre1;
            pre1 = next;
        }
        return pre2;
    }
}
