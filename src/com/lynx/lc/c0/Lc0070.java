package com.lynx.lc.c0;

/**
 * 70.爬楼梯
 */
public class Lc0070 {
    public int climbStairs(int n) {
        int pre1 = 2, pre2 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = pre1;
            pre1 = pre1 + pre2;
            pre2 = temp;
        }
        return pre2;
    }
}
