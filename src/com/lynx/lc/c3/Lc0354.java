package com.lynx.lc.c3;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 */
public class Lc0354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 1) {
            return 1;
        }
        // 宽度由小到大，高度由大到小
        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
        int[] end = new int[n];
        int len = 0;
        for (int i = 0, find; i < n; i++) {
            find = bs(end, len, envelopes[i][1]);
            if (find == -1) {
                end[len++] = envelopes[i][1];
            } else {
                end[find] = envelopes[i][1];
            }
        }
        return len;
    }

    private int bs(int[] end, int len, int target) {
        int l = 0, r = len - 1, m;
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (end[m] >= target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
