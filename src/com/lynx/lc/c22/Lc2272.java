package com.lynx.lc.c22;

/**
 * 2272. 最大波动的子字符串
 *
 * @date 2025/03/16
 */
public class Lc2272 {
    public int largestVariance(String s) {
        int ans = 0;
        for (int x = 'a'; x <= 'z'; ++x) {
            for (int y = 'a'; y <= 'z'; ++y) {
                if (x == y) {
                    continue;
                }
                int f0 = 0;
                int f1 = Integer.MIN_VALUE;
                for (char c : s.toCharArray()) {
                    if (c == x) {
                        f0 = Math.max(f0, 0) + 1;
                        f1++;
                    } else if (c == y) {
                        f0 = Math.max(f0, 0) - 1;
                        f1 = f0;
                    }
                    ans = Math.max(ans, f1);
                }
            }
        }
        return ans;
    }
}
