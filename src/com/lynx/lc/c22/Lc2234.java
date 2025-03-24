package com.lynx.lc.c22;

import java.util.Arrays;

/**
 * 2234.花园的最大总美丽值
 *
 * @date 2025/03/08
 */
public class Lc2234 {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int n = flowers.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            flowers[i] = Math.min(flowers[i], target);
        }
        Arrays.sort(flowers);
        reverse(flowers);

        long totalFlowers = 0;
        for (int flower : flowers) {
            totalFlowers += flower;
        }
        // 如果可以全部填满，初始化
        if ((long)target * n - totalFlowers <= newFlowers) {
            ans = (long)full * n;
        }
        long prefixSum = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                prefixSum += flowers[i - 1];
            }
            if (flowers[i] == target) {
                continue;
            }

            // 把前i个填满后剩余量
            long rest = newFlowers - ((long)target * i - prefixSum);
            // 无法填满，结束循环
            if (rest < 0) {
                break;
            }
            // 使用剩余的花最大化剩余的花园中的最小花园
            // 当前剩余量刚好满足j之后的花园填充到flowers[j]
            while (!(j >= i && (long)flowers[j] * (n - j) - totalFlowers <= rest)) {
                totalFlowers -= flowers[j];
                j++;
            }
            rest -= (long)flowers[j] * (n - j) - totalFlowers;
            long minFlower = Math.min(flowers[j] + rest / (n - j), target - 1);
            ans = Math.max(ans, (long)full * i + (long)partial * minFlower);
        }
        return ans;
    }

    private void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
