package com.lynx.lc.c3;

/**
 * 321. 拼接最大数
 *
 * @apiNote
 * 从两个数组中组成 k 个，可以从两个数组分别获取 k1 + k2 = k 个最大数字，
 * 然后再合并处理。单个数组获取k个最大数组可以参考方法
 * {@link com.lynx.lc.c4.Lc0402#removeKdigits(String, int)}
 * @see com.lynx.lc.c4.Lc0402
 */
public class Lc0321 {
    private final int[] stack = new int[500];

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0; i <= k; i++) {
            if (i > nums1.length || k - i > nums2.length) {
                continue;
            }
            int[] ans1 = findKMaxNumber(nums1, i);
            int[] ans2 = findKMaxNumber(nums2, k - i);
            int[] merged = merge(ans1, ans2);
            if (compare(merged, 0, ans, 0) > 0) {
                ans = merged;
            }
        }
        return ans;
    }

    private int[] findKMaxNumber(int[] nums, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (k == nums.length) {
            return nums;
        }
        // 找到k个最大的 等同于 丢掉n-k个最小的
        int d = nums.length - k;
        int size = 0;
        for (int num : nums) {
            while (size > 0 && stack[size - 1] < num && d > 0) {
                size--;
                d--;
            }
            stack[size++] = num;
        }
        int[] ans = new int[k];
        System.arraycopy(stack, 0, ans, 0, k);
        return ans;
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int x = arr1.length, y = arr2.length;
        if (x == 0) {
            return arr2;
        }
        if (y == 0) {
            return arr1;
        }
        int len = x + y;
        int[] merged = new int[len];
        int p1 = 0, p2 = 0;
        for (int i = 0; i < len; i++) {
            if (compare(arr1, p1, arr2, p2) > 0) {
                merged[i] = arr1[p1++];
            } else {
                merged[i] = arr2[p2++];
            }
        }
        return merged;
    }

    private int compare(int[] arr1, int index1, int[] arr2, int index2) {
        int x = arr1.length, y = arr2.length;
        while (index1 < x && index2 < y) {
            int diff = arr1[index1] - arr2[index2];
            if (diff != 0) {
                return diff;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }
}
