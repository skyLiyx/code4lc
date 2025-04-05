package lyx.lc.c6;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. 最长数对链
 */
public class Lc0646 {
    /**
     * 贪心思想
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(p -> p[1]));
        int pre = Integer.MIN_VALUE, ans = 0;
        for (int[] pair : pairs) {
            if (pair[0] > pre) {
                pre = pair[1];
                ans++;
            }
        }
        return ans;
    }

    /**
     * 最长递增子序列思想
     */
    public int findLongestChain1(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(p -> p[0]));
        int[] ends = new int[pairs.length];
        int len = 0;
        for (int i = 0, find; i < pairs.length; i++) {
            // 找左，放右
            find = bs(ends, len, pairs[i][0]);
            if (find == -1) {
                ends[len++] = pairs[i][1];
            } else {
                ends[find] = Math.min(ends[find], pairs[i][1]);
            }
        }
        return len;
    }

    private int bs(int[] ends, int len, int target) {
        int l = 0, r = len - 1, m, ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (ends[m] >= target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
