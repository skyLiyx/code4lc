package com.lynx.lc.c6;

/**
 * 689. 三个无重叠子数组的最大和
 */
public class Lc0689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        // 所有长度为k的子数组的和
        // sums[i]: [i,i+k-1]范围的累加和
        int[] sums = new int[n];
        for (int l = 0, r = 0, sum = 0; r < n; r++) {
            sum += nums[r];
            if (r - l + 1 == k) {
                sums[l] = sum;
                sum -= nums[l];
                l++;
            }
        }
        // 每个位置之前长度为k的子数组累加和最大的起点
        // leftMax[i]: [0,i]范围内长度为k的累加和最大子数组的起点
        int[] leftMax = new int[n];
        leftMax[k - 1] = 0;
        for (int i = k, j = 1, max = sums[0]; i < n; i++, j++) {
            if (sums[j] <= max) {
                leftMax[i] = leftMax[i - 1];
            } else {
                leftMax[i] = j;
                max = sums[j];
            }
        }
        // 每个位置之后长度为k的子数组累加和最大的起点
        // rightMax[i]: [i, n-1]范围内长度为k的累加和最大子数组的起点
        int[] rightMax = new int[n];
        rightMax[n - k] = n - k;
        for (int i = n - k - 1, max = sums[n - k]; i >= 0; i--) {
            if (sums[i] < max) {
                rightMax[i] = rightMax[i + 1];
            } else {
                rightMax[i] = i;
                max = sums[i];
            }
        }
        // 枚举中间第二段长度为k的子数组的位置，求出三个子数组累加和最大的位置
        int[] ans = new int[3];
        for (int i = k, j = 2 * k - 1, cur, sumOfThree = 0; j < n - k; i++, j++) {
            // [i,j]: 第二段子数组
            cur = sums[leftMax[i - 1]] + sums[i] + sums[rightMax[j + 1]];
            if (cur > sumOfThree) {
                sumOfThree = cur;
                ans[0] = leftMax[i - 1];
                ans[1] = i;
                ans[2] = rightMax[j + 1];
            }
        }
        return ans;
    }
}
