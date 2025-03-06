package com.lynx.lc.c2;

/**
 * 215.数组中的第K个最大元素
 *
 * @apiNote 随机选择
 */
public class Lc0215 {
    public int findKthLargest(int[] nums, int k) {
        return randomizedSelect(nums, nums.length - k);
    }

    private int randomizedSelect(int[] nums, int n) {
        int l = 0, r = nums.length - 1;
        int ans = 0;
        while (l <= r) {
            int[] partitionIndex = partition(nums, l, r);
            if (partitionIndex[0] <= n && partitionIndex[1] >= n) {
                ans = nums[partitionIndex[0]];
                break;
            }
            if (partitionIndex[0] > n) {
                r = partitionIndex[0] - 1;
            } else {
                l = partitionIndex[1] + 1;
            }
        }
        return ans;
    }

    private int[] partition(int[] nums, int l, int r) {
        int less = l, more = r;
        int p = l;
        while (p < more) {
            if (nums[p] < nums[r]) {
                swap(nums, less++, p++);
            } else if (nums[p] > nums[r]) {
                swap(nums, p, --more);
            } else {
                p++;
            }
        }
        swap(nums, more, r);
        return new int[]{less, more};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
