package com.lynx.lc.c27;

/**
 * 2712. 使所有字符相等的最小成本
 *
 * @date 2025/03/27
 */
public class Lc2712 {
    public long minimumCost(String s) {
        long ans = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                // 当前与前面一个不一样（0~i-1一定一样），必须翻转
                // 要么翻转0~i-1位置的
                // 要么翻转i~n-1位置的（只管把i位置翻转成和前面一样）
                ans += Math.min(i, n - i);
            }
        }
        return ans;
    }
}
