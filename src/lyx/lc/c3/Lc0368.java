package lyx.lc.c3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 *
 * @date 2025/04/06
 */
public class Lc0368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // dp[i]: 以i结尾的最长的整除序列长度
        int[] dp = new int[n];
        // g[i]: 以i结尾的最长的整除序列，上一个数的位置
        int[] g = new int[n];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            dp[i] = 1; // 至少包含自身一个数
            g[i] = i; // 上一个数字就是自己
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        g[i] = j;
                    }
                }
            }
            if (dp[max] < dp[i]) {
                max = i;
            }
        }
        int size = dp[max];
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != size) {
            ans.add(nums[max]);
            max = g[max];
        }
        return ans;
    }
}
