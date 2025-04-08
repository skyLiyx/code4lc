package lyx.lc.c6;

/**
 * 683. K 个关闭的灯泡
 */
public class Lc0683 {
    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        if (k > n - 2) {
            return -1;
        }
        if (k == 0) {
            // 从前往后便利，只要出现两个挨着的即可
            int[] help = new int[n + 1];
            for (int i = 0; i < bulbs.length; i++) {
                help[bulbs[i]] = 1;
                if ((bulbs[i] - 1 > 0 && help[bulbs[i] - 1] == 1) || (bulbs[i] + 1 <= n && help[bulbs[i] + 1] == 1)) {
                    return i + 1;
                }
            }
            return -1; // not reachable
        }
        // openTime[i]: 第i盏灯打开的时间
        int[] openTime = new int[n];
        for (int i = 0; i < bulbs.length; i++) {
            openTime[bulbs[i] - 1] = i + 1;
        }
        // 滑动窗口，窗口内所有灯的打开时间均大于窗口两边两盏灯的打开时间即满足条件
        int[] queue = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < k; i++) {
            // 利用单调队列记录窗口内的最小值
            while (l < r && openTime[queue[r - 1]] > openTime[i]) {
                r--;
            }
            queue[r++] = i;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = k; i < n - 1; i++) {
            // 窗口右移，入队列
            while (l < r && openTime[queue[r - 1]] > openTime[i]) {
                r--;
            }
            queue[r++] = i;
            // 满足条件时更新答案
            if (openTime[queue[l]] > openTime[i - k] && openTime[queue[l]] > openTime[i + 1]) {
                ans = Math.min(ans, Math.max(openTime[i - k], openTime[i + 1]));
            }
            // 窗口右移，出队列
            if (queue[l] == i - k + 1) {
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
