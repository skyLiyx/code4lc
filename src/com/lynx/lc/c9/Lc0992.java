package com.lynx.lc.c9;

import java.util.Arrays;

/**
 * 992. K 个不同整数的子数组
 *
 * @apiNote 滑动窗口
 */
public class Lc0992 {
    private final int[] cnt = new int[20001];

    public int subarraysWithKDistinct(int[] nums, int k) {
        // 不同整数的个数恰好为 k = 最多为k的子数组数量 - 最多为k-1的子数组数量
        return numsOfMostKinds(nums, k) - numsOfMostKinds(nums, k - 1);
    }

    private int numsOfMostKinds(int[] nums, int k) {
        int ans = 0;
        Arrays.fill(cnt, 0);
        for (int l = 0, r = 0, kind = 0; r < nums.length; r++) {
            if (cnt[nums[r]]++ == 0) {
                kind++;
            }
            while (kind > k) {
                if (--cnt[nums[l++]] == 0) {
                    kind--;
                }
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
