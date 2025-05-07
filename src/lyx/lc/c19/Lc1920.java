package lyx.lc.c19;

/**
 * 1920. 基于排列构建数组
 *
 * @date 2025/05/06
 */
public class Lc1920 {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
