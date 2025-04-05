package lyx.lc.c21;

/**
 * 2141. 同时运行 N 台电脑的最长时间
 *
 * @apiNote 二分查找
 */
public class Lc2141 {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int battery : batteries) {
            sum += battery;
        }
        long l = 0, r = sum, m;
        long ans = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(n, batteries, m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private boolean check(int n, int[] batteries, long time) {
        long sum = 0;
        // 满足要求时长的，可以直接供给一个电脑一直使用到结束，而
        // 不满足要求时长的，称为碎片数据，针对碎片数据，只要其数
        // 据总和大于等于所有电脑的累加要求时间即可
        for (int battery : batteries) {
            if (battery > time) {
                n--;
            } else {
                sum += battery;
            }
            if (sum >= time * n) {
                return true;
            }
        }
        return false;
    }
}
