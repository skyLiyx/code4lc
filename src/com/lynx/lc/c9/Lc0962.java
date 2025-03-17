package com.lynx.lc.c9;

/**
 * 962. 最大宽度坡
 *
 * @apiNote 单调栈
 */
public class Lc0962 {
    private final int[] stack = new int[50000];

    public int maxWidthRamp(int[] nums) {
        int n = nums.length, size = 0;
        stack[size++] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[stack[size - 1]]) {
                stack[size++] = i;
            }
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (size > 0 && nums[i] >= nums[stack[size - 1]]) {
                ans = Math.max(ans, i - stack[--size]);
            }
        }
        return ans;
    }
}
