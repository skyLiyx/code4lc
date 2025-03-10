package com.lynx.lc.c22;

/**
 * 2269.找到一个数字的K美丽值
 *
 * @date 2025/03/10
 */
public class Lc2269 {
    public int divisorSubstring(int num, int k) {
        String s = String.valueOf(num);
        int ans = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            int sub = Integer.parseInt(s.substring(i, i + k));
            if (sub != 0 && num % sub == 0) {
                ans++;
            }
        }
        return ans;
    }
}
