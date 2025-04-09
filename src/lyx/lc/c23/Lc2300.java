package lyx.lc.c23;

import java.util.Arrays;

/**
 * 2300. 咒语和药水的成功对数
 */
public class Lc2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        int[] pairs = new int[n];
        for (int i = 0; i < n; i++) {
            int r = binarySearch(potions, (success - 1) / spells[i] + 1);
            pairs[i] = r == -1 ? 0 : m - r;
        }
        return pairs;
    }

    private int binarySearch(int[] potions, long target) {
        int l = 0, r = potions.length - 1, m;
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (potions[m] >= target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
