package lyx.lc.c10;

/**
 * 1011. 在 D 天内送达包裹的能力
 */
public class Lc1011 {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }
        int l = max, r = sum, m;
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(weights, m, days)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private boolean check(int[] weights, int mid, int days) {
        for (int i = 0, sum = 0; i < weights.length; ) {
            while (i < weights.length && sum + weights[i] <= mid) {
                sum += weights[i++];
            }
            sum = 0;
            if (--days < 0) {
                return false;
            }
        }
        return true;
    }
}
