package com.lynx.lc.c15;

import java.util.Arrays;

/**
 * 1552.两球之间的磁力
 * 思路：二分查找
 *
 * @date 2025/02/14
 */
public class Lc1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int res = -1;
        int low = 1; // 最小间距
        int high = position[n - 1] - position[0]; // 最大间距
        // 二分查找
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (check(position, mid, m)) {
                // 能放下一个球，加大间距
                low = mid + 1;
                res = mid;
            } else {
                // 不能放下，缩小间距
                high = mid - 1;
            }
        }
        return res;
    }

    private boolean check(int[] position, int mid, int m) {
        // 先放一个球在起始位置
        int cnt = 1; // 球的数量
        int pre = position[0]; // 最后一个球的位置
        for (int j = 1; j < position.length; j++) {
            // 检查间距是否满足
            if (position[j] - pre >= mid) {
                cnt++;
                pre = position[j];
            }
        }
        // 最终检查该间距下能放下的球的数量
        return cnt >= m;
    }
}
