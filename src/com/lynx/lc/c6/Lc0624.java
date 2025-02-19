package com.lynx.lc.c6;

import java.util.List;

/**
 * 624.数组列表中的最大距离
 *
 * @date 2025/02/19
 */
public class Lc0624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        int min = 10001;
        int max = -10001;
        int minPos = -1;
        int maxPos = -1;
        List<Integer> cur;
        for (int i = 0; i < m; i++) {
            cur = arrays.get(i);
            if (min > cur.get(0)) {
                min = cur.get(0);
                minPos = i;
            }
            if (max < cur.get(cur.size() - 1)) {
                max = cur.get(cur.size() - 1);
                maxPos = i;
            }
        }
        if (minPos == maxPos) {
            int secondMin = 10001;
            int secondMax = -10001;
            for (int i = 0; i < m; i++) {
                if (i == minPos) continue;
                cur = arrays.get(i);
                secondMin = Math.min(secondMin, cur.get(0));
                secondMax = Math.max(secondMax, cur.get(cur.size() - 1));
            }
            return Math.max(max - secondMin, secondMax - min);
        } else {
            return max - min;
        }
    }
}
