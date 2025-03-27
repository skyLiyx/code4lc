package com.lynx.lc.c9;

/**
 * 926. 将字符串翻转到单调递增
 */
public class Lc0926 {
    public int minFlipsMonoIncr(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        // prefix[i]: 将i个长度的左半部分全部变为0的成本
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1];
            if (c[i - 1] == '1') {
                prefix[i] += 1;
            }
        }
        // prefix[i]: 将n-i个长度的右半部分全部变为1的成本
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];
            if (c[i] == '0') {
                suffix[i] += 1;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            // 遍历整个长度
            // i个长度的左半部分全变为0，剩余长度的右半部分全变为1
            ans = Math.min(ans, prefix[i] + suffix[i]);
        }
        return ans;
    }
}
