package lyx.lc.c20;

/**
 * 2064. 分配给商店的最多商品的最小值
 *
 * @apiNote 二分查找
 */
public class Lc2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        for (int quantity : quantities) {
            max = Math.max(max, quantity);
        }
        int l = 1, r = max, m;
        int ans = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(n, quantities, m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private boolean check(int n, int[] quantities, int max) {
        for (int quantity : quantities) {
            // 每个店只能分一个商品，所以分到就直接退出
            n -= (quantity + max - 1) / max; // 向上取整
            if (n < 0) {
                return false;
            }
        }
        // 最后还剩有没分到的店，还能再缩小
        return n >= 0;
    }
}
