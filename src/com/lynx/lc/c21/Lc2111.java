package com.lynx.lc.c21;

/**
 * 2111. 使数组 K 递增的最少操作次数
 */
public class Lc2111 {
    private static final int MAXN = 100001;
    private static final int[] nums = new int[MAXN];
    private static final int[] ends = new int[MAXN];

    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        // 分为 K 组，每组互不影响，找出每组最长递增子序列的长度，缺失的部分就是需要修改的
        for (int i = 0; i < k; i++) {
            int size = 0;
            for (int j = i; j < n; j += k) {
                nums[size++] = arr[j];
            }
            ans += size - lengthOfLIS(size);
        }
        return ans;
    }

    private int lengthOfLIS(int size) {
        int len = 0;
        for (int i = 0, find; i < size; i++) {
            find = bs(len, nums[i]);
            if (find == -1) {
                ends[len++] = nums[i];
            } else {
                ends[find] = nums[i];
            }
        }
        return len;
    }

    private int bs(int len, int target) {
        int l = 0, r = len - 1, m, ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (ends[m] > target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
