package com.lynx.lc.c20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2070.每一个查询的最大美丽值
 *
 * @date 2025/03/09
 */
public class Lc2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        for (int[] item : items) {
            pre = Math.max(pre, item[1]);
            map.put(item[0], pre);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = binarySearch(items, queries[i]);
            ans[i] = index == -1 ? 0 : map.get(items[index][0]);
        }
        return ans;
    }

    private int binarySearch(int[][] items, int price) {
        int l = 0, r = items.length - 1, m;
        int ans = -1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (items[m][0] <= price) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
