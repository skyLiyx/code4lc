package com.lynx.lc.c0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * @apiNote 双指针
 */
public class Lc0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0] > 0 || nums[n - 1] < 0) {
            return ans;
        }
        for (int i = 0, l, r; i < n - 1; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            // 以下标i作为基准，在右边寻找另外两个数
            l = i + 1;
            r = n - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] > 0) {
                    // 结果偏大，减小r
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    // 结果偏小，增加l
                    l++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 跳过重复的组合
                    while (l < r && nums[l + 1] == nums[l]) {
                        l++;
                    }
                    while (r > l && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return ans;
    }
}
