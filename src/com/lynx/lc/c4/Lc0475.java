package com.lynx.lc.c4;

import java.util.Arrays;

/**
 * 475. 供暖器
 */
public class Lc0475 {
    public int findRadius(int[] houses, int[] heaters) {
        int m = houses.length;
        int n = heaters.length;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < m; i++) {
            // 如果离下一个更近，那么当前就选下一个
            while (j < n - 1 && Math.abs(houses[i] - heaters[j]) <= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
            }
            ans = Math.max(ans, Math.abs(houses[i] - heaters[j]));
        }
        return ans;
    }
}
