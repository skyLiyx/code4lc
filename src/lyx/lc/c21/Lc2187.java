package lyx.lc.c21;

/**
 * 2187. 完成旅途的最少时间
 */
public class Lc2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1, r = time[0], m;
        for (int i = 1; i < time.length; i++) {
            r = Math.min(r, time[i]);
        }
        // 二分最大值, 就是用耗时最低的跑完全部的耗时
        r *= totalTrips;
        long ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(time, m, totalTrips)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private boolean check(int[] time, long mid, int totalTrips) {
        long sum = 0;
        for (int i : time) {
            sum += mid / i;
            if (sum >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}
