package com.lynx.lc.c9;

/**
 * 974. 和可被 K 整除的子数组
 */
public class Lc0974 {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        // map[i]表示mod值为i已出现的数量
        int[] map = new int[k + 1];
        map[0] = 1;
        for (int i = 0, sum = 0, mod; i < nums.length; i++) {
            sum += nums[i];
            mod = (sum % k + k) % k;
            ans += map[mod];
            map[mod]++;
        }
        return ans;
    }
}
