package com.lynx.lc.c26;

/**
 * 2614. 对角线上的质数
 *
 * @date 2025/03/18
 */
public class Lc2614 {
    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i][i] > ans && isPrime(nums[i][i])) {
                ans = nums[i][i];
            }
            if (nums[i][n - 1 - i] > ans && isPrime(nums[i][n - 1 - i])) {
                ans = nums[i][n - 1 - i];
            }
        }
        return ans;
    }

    private boolean isPrime(int n) {
        if (n < 3) {
            return n == 2;
        }
        if ((n & 1) == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
