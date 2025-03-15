package com.lynx.lc.c0;

/**
 * 42. 接雨水
 */
public class Lc0042 {
    public int trap(int[] height) {
        int n = height.length;
        int lmax = height[0];
        int rmax = height[n - 1];
        int ans = 0;
        int l = 1, r = n - 2;
        while (l <= r) {
            if (lmax <= rmax) {
                // 如果左边小，l右边的最大值>=rmax，左边是短板
                ans += Math.max(0, lmax - height[l]);
                lmax = Math.max(lmax, height[l]);
                l++;
            } else {
                // 如果右边小，r左边的最大值>=lmax，右边是短板
                ans += Math.max(0, rmax - height[r]);
                rmax = Math.max(rmax, height[r]);
                r--;
            }
        }
        return ans;
    }
}
