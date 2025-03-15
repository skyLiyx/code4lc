package com.lynx.lc.c11;

/**
 * 1109. 航班预订统计
 *
 * @apiNote 差分
 */
public class Lc1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n + 2];
        for (int[] booking : bookings) {
            arr[booking[0]] += booking[2];
            arr[booking[1] + 1] -= booking[2];
        }
        int[] ans = new int[n];
        for(int i = 1; i < n + 1; i++) {
            arr[i] += arr[i - 1];
            ans[i - 1] = arr[i];
        }
        return ans;
    }
}
