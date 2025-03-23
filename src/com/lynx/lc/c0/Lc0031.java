package com.lynx.lc.c0;

import java.util.Arrays;

/**
 * 31. 下一个排列
 */
public class Lc0031 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index, nextIndex;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                nextIndex = i + 1;
                for (int j = i + 2; j < n; j++) {
                    if (nums[j] > nums[i] && nums[j] < nums[nextIndex]) {
                        nextIndex = j;
                    }
                }
                swap(nums, index, nextIndex);
                reverse(nums, index + 1, n - 1);
                return;
            }
        }
        Arrays.sort(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
