package com.lynx.lc.c0;

import java.util.Arrays;

/**
 * 3. 无重复字符的最长子串
 *
 * @apiNote 滑动窗口
 */
public class Lc0003 {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];
        Arrays.fill(arr, -1);
        int ans = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (arr[s.charAt(r)] != -1 && arr[s.charAt(r)] >= l) {
                // 在窗口范围内遇到重复字符，调整窗口
                l = arr[s.charAt(r)] + 1;
            } else {
                ans = Math.max(ans, r - l + 1);
            }
            arr[s.charAt(r)] = r;
        }
        return ans;
    }
}
