package lyx.lc.c5;

import java.util.Arrays;

/**
 * 503. 下一个更大元素 II
 */
public class Lc0503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n << 1];
        int size = 0;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0, cur; i < n; i++) {
            while (size > 0 && nums[i] > nums[stack[size - 1]]) {
                cur = stack[--size];
                ans[cur] = nums[i];
            }
            stack[size++] = i;
        }
        for (int i = 0, cur; i < n; i++) {
            while (size > 0 && nums[i] > nums[stack[size - 1]]) {
                cur = stack[--size];
                ans[cur] = nums[i];
            }
            stack[size++] = i;
        }
        return ans;
    }
}
